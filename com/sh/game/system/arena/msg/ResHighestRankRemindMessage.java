package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送最高名次提醒</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHighestRankRemindMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHighestRankRemindMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37010;
	}
	
	/**
	 * startRank
	 */
	private int startRank;

	public int getStartRank() {
		return startRank;
	}

	public void setStartRank(int startRank) {
		this.startRank = startRank;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.startRank = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, startRank, false);
		return true;
	}
}
