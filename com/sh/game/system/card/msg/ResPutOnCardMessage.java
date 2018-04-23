package com.sh.game.system.card.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.card.msg.bean.CardBean;

/**
 * <p>返回穿戴卡片</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResPutOnCardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResPutOnCardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 51003;
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
	 * 穿上的卡片
	 */
	private CardBean cardBean;

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

		public CardBean getCardBean() {
		return cardBean;
	}

	public void setCardBean(CardBean cardBean) {
		this.cardBean = cardBean;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		if (readByte(buf) != 0) {
			CardBean cardBean = new CardBean();
			cardBean.read(buf);
			this.cardBean = cardBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeBean(buf, cardBean);
		return true;
	}
}
