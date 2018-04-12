package com.sh.game.system.duobao.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求抢夺宝物</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqRobMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRobMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48006;
	}
	
	/**
	 * 被抢玩家id
	 */
	private int roleId;


	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.roleId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, roleId, false);

		return true;
	}
}

