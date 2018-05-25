package com.sh.game.system.vip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求领取月卡每日福利</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetCardDayRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetCardDayRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 28002;
	}
	
	/**
	 * 月卡id
	 */
	private int cardId;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.cardId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, cardId, false);
		return true;
	}
}
