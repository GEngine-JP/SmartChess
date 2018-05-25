package com.sh.game.system.vip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.vip.msg.bean.CardBean;

/**
 * <p>返回月卡改变</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResMonthCardChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResMonthCardChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 28003;
	}
	
	/**
	 * 月卡
	 */
	private CardBean cardBean;

	public CardBean getCardBean() {
		return cardBean;
	}

	public void setCardBean(CardBean cardBean) {
		this.cardBean = cardBean;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			CardBean cardBean = new CardBean();
			cardBean.read(buf);
			this.cardBean = cardBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, cardBean);
		return true;
	}
}
