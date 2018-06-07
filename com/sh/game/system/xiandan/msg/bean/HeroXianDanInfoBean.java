package com.sh.game.system.xiandan.msg.bean;

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

public class HeroXianDanInfoBean extends KryoBean {

	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 英雄仙丹战力
	 */
	private int fightPower;
	/**
	 * 仙丹信息
	 */
	private List<XianDanInfoBean> xianDanInfoList = new ArrayList<>();

	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

		public int getFightPower() {
		return fightPower;
	}

	public void setFightPower(int fightPower) {
		this.fightPower = fightPower;
	}

		public List<XianDanInfoBean> getXianDanInfoList() {
		return xianDanInfoList;
	}

	public void setXianDanInfoList(List<XianDanInfoBean> xianDanInfoList) {
		this.xianDanInfoList = xianDanInfoList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.heroId = readLong(buf);
		this.fightPower = readInt(buf, false);
		int xianDanInfoListLength = readShort(buf);
		for (int xianDanInfoListI = 0; xianDanInfoListI < xianDanInfoListLength; xianDanInfoListI++) {
			if (readByte(buf) == 0) { 
				this.xianDanInfoList.add(null);
			} else {
				XianDanInfoBean xianDanInfoBean = new XianDanInfoBean();
				xianDanInfoBean.read(buf);
				this.xianDanInfoList.add(xianDanInfoBean);
			}
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, heroId);
		this.writeInt(buf, fightPower, false);
		writeShort(buf, this.xianDanInfoList.size());
		for (int xianDanInfoListI = 0; xianDanInfoListI < this.xianDanInfoList.size(); xianDanInfoListI++) {
			this.writeBean(buf, this.xianDanInfoList.get(xianDanInfoListI));
		}
		return true;
	}
}
