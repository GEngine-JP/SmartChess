package com.sh.game.system.redenvelop.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回领取红包结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDrawRedEnvelopMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDrawRedEnvelopMessage() {
		this.queueId = 0;
	}
	
	@Override
	public int getId() {
		return 63003;
	}
	
	/**
	 * 红包id
	 */
	private int redEnvelopId;
	/**
	 * 是否领取成功 0 失败 1 成功
	 */
	private int isSuc;
	/**
	 * 元宝数量
	 */
	private int coinNum;
	/**
	 * 历史领取记录
	 */
	private List<Integer> drawRecords = new ArrayList<>();
	/**
	 * 待领取数量
	 */
	private int notYetGet;

	public int getRedEnvelopId() {
		return redEnvelopId;
	}

	public void setRedEnvelopId(int redEnvelopId) {
		this.redEnvelopId = redEnvelopId;
	}

		public int getIsSuc() {
		return isSuc;
	}

	public void setIsSuc(int isSuc) {
		this.isSuc = isSuc;
	}

		public int getCoinNum() {
		return coinNum;
	}

	public void setCoinNum(int coinNum) {
		this.coinNum = coinNum;
	}

		public List<Integer> getDrawRecords() {
		return drawRecords;
	}

	public void setDrawRecords(List<Integer> drawRecords) {
		this.drawRecords = drawRecords;
	}
	public int getNotYetGet() {
		return notYetGet;
	}

	public void setNotYetGet(int notYetGet) {
		this.notYetGet = notYetGet;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.redEnvelopId = readInt(buf, false);
		this.isSuc = readInt(buf, false);
		this.coinNum = readInt(buf, false);
		int drawRecordsLength = readShort(buf);
		for (int drawRecordsI = 0; drawRecordsI < drawRecordsLength; drawRecordsI++) {
			this.drawRecords.add(this.readInt(buf, false));
		}		this.notYetGet = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, redEnvelopId, false);
		this.writeInt(buf, isSuc, false);
		this.writeInt(buf, coinNum, false);
		writeShort(buf, this.drawRecords.size());
		for (int drawRecordsI = 0; drawRecordsI < this.drawRecords.size(); drawRecordsI++) {
			this.writeInt(buf, this.drawRecords.get(drawRecordsI), false);
		}		this.writeInt(buf, notYetGet, false);
		return true;
	}
}
