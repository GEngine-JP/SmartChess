package com.sh.game.system.battle.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求进入战斗</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqFightMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqFightMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 25001;
	}
	
	/**
	 * 战斗的目标
	 */
	private long targetUid;
	/**
	 * 战斗类型0正常战斗 1抢夺归属
	 */
	private int fightType;

	public long getTargetUid() {
		return targetUid;
	}

	public void setTargetUid(long targetUid) {
		this.targetUid = targetUid;
	}

		public int getFightType() {
		return fightType;
	}

	public void setFightType(int fightType) {
		this.fightType = fightType;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.targetUid = readLong(buf);
		this.fightType = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, targetUid);
		this.writeInt(buf, fightType, false);
		return true;
	}
}
