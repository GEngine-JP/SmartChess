package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.robtreasure.msg.bean.LingBaoBean;


/**
 * <p>返回灵宝升级</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResLevelUpLingBaoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLevelUpLingBaoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50021;
	}
	
	/**
	 * 1、玩家 2、英雄 3、背包
	 */
	private int type;

	/**
	 * 英雄id
	 */
	private long heroId;

	/**
	 * 改变的灵宝
	 */
	private LingBaoBean lingBaoBean;


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

	
	public LingBaoBean getLingBaoBean() {
		return lingBaoBean;
	}

	public void setLingBaoBean(LingBaoBean lingBaoBean) {
		this.lingBaoBean = lingBaoBean;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		if (readByte(buf) != 0) {
			LingBaoBean lingBaoBean = new LingBaoBean();
			lingBaoBean.read(buf);
			this.lingBaoBean = lingBaoBean;
		}

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeBean(buf, lingBaoBean);

		return true;
	}
}

