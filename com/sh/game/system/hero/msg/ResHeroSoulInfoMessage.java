package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.hero.msg.bean.HeroSoulBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送英雄灵魂刻印信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResHeroSoulInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroSoulInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22016;
	}
	
	/**
	 * 刻印信息
	 */
	private List<HeroSoulBean> soulInfo = new ArrayList<HeroSoulBean>();


	public List<HeroSoulBean> getSoulInfo() {
		return soulInfo;
	}

	public void setSoulInfo(List<HeroSoulBean> soulInfo) {
		this.soulInfo = soulInfo;
	}


	@Override
	public boolean read(KryoInput buf) {
		int soulInfoLength = readShort(buf);
		for (int soulInfoI = 0; soulInfoI < soulInfoLength; soulInfoI++) {
			if (readByte(buf) == 0) { 
				this.soulInfo.add(null);
			} else {
				HeroSoulBean heroSoulBean = new HeroSoulBean();
				heroSoulBean.read(buf);
				this.soulInfo.add(heroSoulBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.soulInfo.size());
		for (int soulInfoI = 0; soulInfoI < this.soulInfo.size(); soulInfoI++) {
			this.writeBean(buf, this.soulInfo.get(soulInfoI));
		}


		return true;
	}
}

