package com.sh.game.system.tower.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回领取转盘奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResGetWheelRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResGetWheelRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 54012;
	}
	
	/**
	 * 中奖位置
	 */
	private int index;
	/**
	 * 本轮抽奖是否结束 0未结束 1结束
	 */
	private int isOver;
	/**
	 * 是否最后一轮 0否 1是
	 */
	private int isLast;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

		public int getIsOver() {
		return isOver;
	}

	public void setIsOver(int isOver) {
		this.isOver = isOver;
	}

		public int getIsLast() {
		return isLast;
	}

	public void setIsLast(int isLast) {
		this.isLast = isLast;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.index = readInt(buf, false);
		this.isOver = readInt(buf, false);
		this.isLast = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, index, false);
		this.writeInt(buf, isOver, false);
		this.writeInt(buf, isLast, false);
		return true;
	}
}
