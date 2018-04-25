package com.sh.game.system.treasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.treasure.msg.bean.HeroTreasureBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回所有宝物信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHeroAllTreasureInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroAllTreasureInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 14015;
	}
	
	/**
	 * 所有英难宝物信息
	 */
	private List<HeroTreasureBean> heroTreasureList = new ArrayList<>();

	public List<HeroTreasureBean> getHeroTreasureList() {
		return heroTreasureList;
	}

	public void setHeroTreasureList(List<HeroTreasureBean> heroTreasureList) {
		this.heroTreasureList = heroTreasureList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int heroTreasureListLength = readShort(buf);
		for (int heroTreasureListI = 0; heroTreasureListI < heroTreasureListLength; heroTreasureListI++) {
			if (readByte(buf) == 0) { 
				this.heroTreasureList.add(null);
			} else {
				HeroTreasureBean heroTreasureBean = new HeroTreasureBean();
				heroTreasureBean.read(buf);
				this.heroTreasureList.add(heroTreasureBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.heroTreasureList.size());
		for (int heroTreasureListI = 0; heroTreasureListI < this.heroTreasureList.size(); heroTreasureListI++) {
			this.writeBean(buf, this.heroTreasureList.get(heroTreasureListI));
		}
		return true;
	}
}
