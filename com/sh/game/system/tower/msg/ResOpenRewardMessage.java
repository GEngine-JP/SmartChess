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
	/**
	 * 本轮抽奖是否结束 0未结束 1结束
	 */
	private int isOver;

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

	
	@Override
	public boolean read(KryoInput buf) {

		this.index = readInt(buf, false);
		this.isOver = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, index, false);
		this.writeInt(buf, isOver, false);
		return true;
	}
}
