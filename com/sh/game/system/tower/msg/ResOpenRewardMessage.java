package com.sh.game.system.tower.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回开奖信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResOpenRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOpenRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 54009;
	}
	
	/**
	 * 中奖位置
	 */
	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.index = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, index, false);
		return true;
	}
}