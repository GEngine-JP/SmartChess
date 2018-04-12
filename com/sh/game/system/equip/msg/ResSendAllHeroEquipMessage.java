package com.sh.game.system.equip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.equip.msg.bean.HeroEquipsBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送所有英雄装备信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendAllHeroEquipMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendAllHeroEquipMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 13003;
	}
	
	/**
	 * 所有英雄的装备信息
	 */
	private List<HeroEquipsBean> heroEquips = new ArrayList<HeroEquipsBean>();


	public List<HeroEquipsBean> getHeroEquips() {
		return heroEquips;
	}

	public void setHeroEquips(List<HeroEquipsBean> heroEquips) {
		this.heroEquips = heroEquips;
	}


	@Override
	public boolean read(KryoInput buf) {
		int heroEquipsLength = readShort(buf);
		for (int heroEquipsI = 0; heroEquipsI < heroEquipsLength; heroEquipsI++) {
			if (readByte(buf) == 0) { 
				this.heroEquips.add(null);
			} else {
				HeroEquipsBean heroEquipsBean = new HeroEquipsBean();
				heroEquipsBean.read(buf);
				this.heroEquips.add(heroEquipsBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.heroEquips.size());
		for (int heroEquipsI = 0; heroEquipsI < this.heroEquips.size(); heroEquipsI++) {
			this.writeBean(buf, this.heroEquips.get(heroEquipsI));
		}


		return true;
	}
}

