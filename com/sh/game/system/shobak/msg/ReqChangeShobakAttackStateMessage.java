package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求更改沙巴克攻击状态</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqChangeShobakAttackStateMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqChangeShobakAttackStateMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40009;
	}
	
	/**
	 * 攻击状态1攻击玩家2攻击雕像3守卫4走路
	 */
	private int state;
	/**
	 * 目标id
	 */
	private long targetId;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

		public long getTargetId() {
		return targetId;
	}

	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.state = readInt(buf, false);
		this.targetId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, state, false);
		this.writeLong(buf, targetId);
		return true;
	}
}
