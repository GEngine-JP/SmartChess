package com.sh.game.system.mining.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求抢夺某玩家</p>
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
		return 48005;
	}
	
	/**
	 * 玩家id
	 */
	private long roleId;


	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.roleId = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, roleId);

		return true;
	}
}

