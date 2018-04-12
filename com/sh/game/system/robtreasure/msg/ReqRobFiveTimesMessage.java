package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求夺五次</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqRobFiveTimesMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRobFiveTimesMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50008;
	}
	
	/**
	 * 被抢玩家id
	 */
	private long roleId;

	/**
	 * 碎片id
	 */
	private int fragmentId;


	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	
	public int getFragmentId() {
		return fragmentId;
	}

	public void setFragmentId(int fragmentId) {
		this.fragmentId = fragmentId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.roleId = readLong(buf);
		this.fragmentId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, roleId);
		this.writeInt(buf, fragmentId, false);

		return true;
	}
}

