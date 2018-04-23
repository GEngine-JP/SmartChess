package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送沙巴克战斗者的信息(退出地图)</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResNoticeFighterExitMapMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResNoticeFighterExitMapMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40008;
	}
	
	/**
	 * 退出的玩家id
	 */
	private long exitId;

	public long getExitId() {
		return exitId;
	}

	public void setExitId(long exitId) {
		this.exitId = exitId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.exitId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, exitId);
		return true;
	}
}
