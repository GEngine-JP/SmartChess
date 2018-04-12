package com.sh.game.system.fight.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.fight.msg.bean.RoleTeamInfoBean;
import com.sh.game.system.fight.msg.bean.OwnerInfoBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回多人副本视野信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResMultiInsViewInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResMultiInsViewInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 25003;
	}
	
	/**
	 * 视野信息
	 */
	private List<RoleTeamInfoBean> roleBean = new ArrayList<RoleTeamInfoBean>();

	/**
	 * 归属者信息
	 */
	private OwnerInfoBean ownerInfo;

	/**
	 * 状态 进入为1 其他为0
	 */
	private int state;


	public List<RoleTeamInfoBean> getRoleBean() {
		return roleBean;
	}

	public void setRoleBean(List<RoleTeamInfoBean> roleBean) {
		this.roleBean = roleBean;
	}

	public OwnerInfoBean getOwnerInfo() {
		return ownerInfo;
	}

	public void setOwnerInfo(OwnerInfoBean ownerInfo) {
		this.ownerInfo = ownerInfo;
	}

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		int roleBeanLength = readShort(buf);
		for (int roleBeanI = 0; roleBeanI < roleBeanLength; roleBeanI++) {
			if (readByte(buf) == 0) { 
				this.roleBean.add(null);
			} else {
				RoleTeamInfoBean roleTeamInfoBean = new RoleTeamInfoBean();
				roleTeamInfoBean.read(buf);
				this.roleBean.add(roleTeamInfoBean);
			}
		}

		if (readByte(buf) != 0) {
			OwnerInfoBean ownerInfoBean = new OwnerInfoBean();
			ownerInfoBean.read(buf);
			this.ownerInfo = ownerInfoBean;
		}
		this.state = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.roleBean.size());
		for (int roleBeanI = 0; roleBeanI < this.roleBean.size(); roleBeanI++) {
			this.writeBean(buf, this.roleBean.get(roleBeanI));
		}

		this.writeBean(buf, ownerInfo);
		this.writeInt(buf, state, false);

		return true;
	}
}

