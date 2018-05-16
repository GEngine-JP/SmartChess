package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.hero.msg.bean.HeroVeinBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送所有经脉信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendAllHeroVeinInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendAllHeroVeinInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22013;
	}
	
	/**
	 * 所有英雄的经脉信息
	 */
	private List<HeroVeinBean> heroVeins = new ArrayList<>();

	public List<HeroVeinBean> getHeroVeins() {
		return heroVeins;
	}

	public void setHeroVeins(List<HeroVeinBean> heroVeins) {
		this.heroVeins = heroVeins;
	}

	@Override
	public boolean read(KryoInput buf) {

		int heroVeinsLength = readShort(buf);
		for (int heroVeinsI = 0; heroVeinsI < heroVeinsLength; heroVeinsI++) {
			if (readByte(buf) == 0) { 
				this.heroVeins.add(null);
			} else {
				HeroVeinBean heroVeinBean = new HeroVeinBean();
				heroVeinBean.read(buf);
				this.heroVeins.add(heroVeinBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.heroVeins.size());
		for (int heroVeinsI = 0; heroVeinsI < this.heroVeins.size(); heroVeinsI++) {
			this.writeBean(buf, this.heroVeins.get(heroVeinsI));
		}
		return true;
	}
}
