package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.robtreasure.msg.bean.RoleBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回有碎片的玩家列表</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResRobTreasureRankMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRobTreasureRankMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50004;
	}
	
	/**
	 * 玩家
	 */
	private List<RoleBean> roleList = new ArrayList<RoleBean>();


	public List<RoleBean> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleBean> roleList) {
		this.roleList = roleList;
	}


	@Override
	public boolean read(KryoInput buf) {
		int roleListLength = readShort(buf);
		for (int roleListI = 0; roleListI < roleListLength; roleListI++) {
			if (readByte(buf) == 0) { 
				this.roleList.add(null);
			} else {
				RoleBean roleBean = new RoleBean();
				roleBean.read(buf);
				this.roleList.add(roleBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.roleList.size());
		for (int roleListI = 0; roleListI < this.roleList.size(); roleListI++) {
			this.writeBean(buf, this.roleList.get(roleListI));
		}


		return true;
	}
}

