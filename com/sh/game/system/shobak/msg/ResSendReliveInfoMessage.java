package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>沙巴克复活信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendReliveInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendReliveInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40021;
	}
	
	/**
	 * 复活次数
	 */
	private int reliveNum;
	/**
	 * 买活次数
	 */
	private int buyReliveNum;

	public int getReliveNum() {
		return reliveNum;
	}

	public void setReliveNum(int reliveNum) {
		this.reliveNum = reliveNum;
	}

		public int getBuyReliveNum() {
		return buyReliveNum;
	}

	public void setBuyReliveNum(int buyReliveNum) {
		this.buyReliveNum = buyReliveNum;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.reliveNum = readInt(buf, false);
		this.buyReliveNum = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, reliveNum, false);
		this.writeInt(buf, buyReliveNum, false);
		return true;
	}
}
