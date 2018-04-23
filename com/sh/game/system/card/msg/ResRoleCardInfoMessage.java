package com.sh.game.system.card.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.card.msg.bean.CardBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送玩家卡片信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRoleCardInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRoleCardInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 51009;
	}
	
	/**
	 * 1角色 2英雄
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 卡片列表
	 */
	private List<CardBean> cardList = new ArrayList<>();

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

		public List<CardBean> getCardList() {
		return cardList;
	}

	public void setCardList(List<CardBean> cardList) {
		this.cardList = cardList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
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

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		writeShort(buf, this.cardList.size());
		for (int cardListI = 0; cardListI < this.cardList.size(); cardListI++) {
			this.writeBean(buf, this.cardList.get(cardListI));
		}
		return true;
	}
}
