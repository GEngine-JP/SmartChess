package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.role.msg.bean.RoleSettingBean;

/**
 * <p>角色设置变化返回</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRoleSettingChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRoleSettingChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8024;
	}
	
	/**
	 * 变化设置
	 */
	private RoleSettingBean roleSettingBean;

	public RoleSettingBean getRoleSettingBean() {
		return roleSettingBean;
	}

	public void setRoleSettingBean(RoleSettingBean roleSettingBean) {
		this.roleSettingBean = roleSettingBean;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			RoleSettingBean roleSettingBean = new RoleSettingBean();
			roleSettingBean.read(buf);
			this.roleSettingBean = roleSettingBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, roleSettingBean);
		return true;
	}
}
