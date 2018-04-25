package com.sh.game.system.treasure.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class HeroTreasureBean extends KryoBean {

	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 英雄宝物bean
	 */
	private List<TreasureBean> treasureBean = new ArrayList<>();

	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

		public List<TreasureBean> getTreasureBean() {
		return treasureBean;
	}

	public void setTreasureBean(List<TreasureBean> treasureBean) {
		this.treasureBean = treasureBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.heroId = readLong(buf);
		int treasureBeanLength = readShort(buf);
		for (int treasureBeanI = 0; treasureBeanI < treasureBeanLength; treasureBeanI++) {
			if (readByte(buf) == 0) { 
				this.treasureBean.add(null);
			} else {
				TreasureBean treasureBean = new TreasureBean();
				treasureBean.read(buf);
				this.treasureBean.add(treasureBean);
			}
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, heroId);
		writeShort(buf, this.treasureBean.size());
		for (int treasureBeanI = 0; treasureBeanI < this.treasureBean.size(); treasureBeanI++) {
			this.writeBean(buf, this.treasureBean.get(treasureBeanI));
		}
		return true;
	}
}
