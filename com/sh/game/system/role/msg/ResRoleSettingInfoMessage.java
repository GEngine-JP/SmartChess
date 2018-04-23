package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.role.msg.bean.RoleSettingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>角色设置消息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRoleSettingInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRoleSettingInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8025;
	}
	
	/**
	 * 角色设置
	 */
	private List<RoleSettingBean> roleSettingBean = new ArrayList<>();

	public List<RoleSettingBean> getRoleSettingBean() {
		return roleSettingBean;
	}

	public void setRoleSettingBean(List<RoleSettingBean> roleSettingBean) {
		this.roleSettingBean = roleSettingBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		int roleSettingBeanLength = readShort(buf);
		for (int roleSettingBeanI = 0; roleSettingBeanI < roleSettingBeanLength; roleSettingBeanI++) {
			if (readByte(buf) == 0) { 
				this.roleSettingBean.add(null);
			} else {
				RoleSettingBean roleSettingBean = new RoleSettingBean();
				roleSettingBean.read(buf);
				this.roleSettingBean.add(roleSettingBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.roleSettingBean.size());
		for (int roleSettingBeanI = 0; roleSettingBeanI < this.roleSettingBean.size(); roleSettingBeanI++) {
			this.writeBean(buf, this.roleSettingBean.get(roleSettingBeanI));
		}
		return true;
	}
}
