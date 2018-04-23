package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.hero.msg.bean.HeroSoulBean;

/**
 * <p>发送英雄灵魂刻印变化</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHeroSoulChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroSoulChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22017;
	}
	
	/**
	 * 刻印信息
	 */
	private HeroSoulBean soulInfo;

	public HeroSoulBean getSoulInfo() {
		return soulInfo;
	}

	public void setSoulInfo(HeroSoulBean soulInfo) {
		this.soulInfo = soulInfo;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			HeroSoulBean heroSoulBean = new HeroSoulBean();
			heroSoulBean.read(buf);
			this.soulInfo = heroSoulBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, soulInfo);
		return true;
	}
}
