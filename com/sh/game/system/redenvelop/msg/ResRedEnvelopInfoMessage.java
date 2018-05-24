package com.sh.game.system.redenvelop.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送红包信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRedEnvelopInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRedEnvelopInfoMessage() {
		this.queueId = 0;
	}
	
	@Override
	public int getId() {
		return 63001;
	}
	
	/**
	 * 红包id
	 */
	private int redEnvelopId;
	/**
	 * 元宝数量
	 */
	private int coinNum;
	/**
	 * 历史领取数量
	 */
	private int drawTotal;

	public int getRedEnvelopId() {
		return redEnvelopId;
	}

	public void setRedEnvelopId(int redEnvelopId) {
		this.redEnvelopId = redEnvelopId;
	}

		public int getCoinNum() {
		return coinNum;
	}

	public void setCoinNum(int coinNum) {
		this.coinNum = coinNum;
	}

		public int getDrawTotal() {
		return drawTotal;
	}

	public void setDrawTotal(int drawTotal) {
		this.drawTotal = drawTotal;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.redEnvelopId = readInt(buf, false);
		this.coinNum = readInt(buf, false);
		this.drawTotal = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, redEnvelopId, false);
		this.writeInt(buf, coinNum, false);
		this.writeInt(buf, drawTotal, false);
		return true;
	}
}
