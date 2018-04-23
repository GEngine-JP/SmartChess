package com.sh.game.system.equip.msg.bean;

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

public class HeroEquipsBean extends KryoBean {

	/**
	 * 装备信息
	 */
	private List<EquipBean> equips = new ArrayList<>();
	/**
	 * 英雄id
	 */
	private long heroId;

	public List<EquipBean> getEquips() {
		return equips;
	}

	public void setEquips(List<EquipBean> equips) {
		this.equips = equips;
	}
	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int equipsLength = readShort(buf);
		for (int equipsI = 0; equipsI < equipsLength; equipsI++) {
			if (readByte(buf) == 0) { 
				this.equips.add(null);
			} else {
				EquipBean equipBean = new EquipBean();
				equipBean.read(buf);
				this.equips.add(equipBean);
			}
		}		this.heroId = readLong(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.equips.size());
		for (int equipsI = 0; equipsI < this.equips.size(); equipsI++) {
			this.writeBean(buf, this.equips.get(equipsI));
		}		this.writeLong(buf, heroId);
		return true;
	}
}
