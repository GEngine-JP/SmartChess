package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送玩家历史最高排名</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResHistoryHighestRankMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHistoryHighestRankMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37004;
	}
	
	/**
	 * 历史最高排名
	 */
	private int highestRank;


	public int getHighestRank() {
		return highestRank;
	}

	public void setHighestRank(int highestRank) {
		this.highestRank = highestRank;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.highestRank = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, highestRank, false);

		return true;
	}
}

