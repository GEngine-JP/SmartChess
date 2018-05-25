package com.sh.game.system.vip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.vip.msg.bean.CardBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回月卡信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRoleMonthCardInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRoleMonthCardInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 28001;
	}
	
	/**
	 * 月卡
	 */
	private List<CardBean> cardList = new ArrayList<>();

	public List<CardBean> getCardList() {
		return cardList;
	}

	public void setCardList(List<CardBean> cardList) {
		this.cardList = cardList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int cardListLength = readShort(buf);
		for (int cardListI = 0; cardListI < cardListLength; cardListI++) {
			if (readByte(buf) == 0) { 
				this.cardList.add(null);
			} else {
				CardBean cardBean = new CardBean();
				cardBean.read(buf);
				this.cardList.add(cardBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.cardList.size());
		for (int cardListI = 0; cardListI < this.cardList.size(); cardListI++) {
			this.writeBean(buf, this.cardList.get(cardListI));
		}
		return true;
	}
}
