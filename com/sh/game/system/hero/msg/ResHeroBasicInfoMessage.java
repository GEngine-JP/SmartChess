package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.hero.msg.bean.HerosAttributeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>英雄基本数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHeroBasicInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroBasicInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22001;
	}
	
	/**
	 * 等级
	 */
	private int level;
	/**
	 * 转生等级
	 */
	private int reinLevel;
	/**
	 * 经验值
	 */
	private long exp;
	/**
	 * 英雄信息
	 */
	private List<HerosAttributeBean> heroInfo = new ArrayList<>();

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

		public int getReinLevel() {
		return reinLevel;
	}

	public void setReinLevel(int reinLevel) {
		this.reinLevel = reinLevel;
	}

		public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

		public List<HerosAttributeBean> getHeroInfo() {
		return heroInfo;
	}

	public void setHeroInfo(List<HerosAttributeBean> heroInfo) {
		this.heroInfo = heroInfo;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.level = readInt(buf, false);
		this.reinLevel = readInt(buf, false);
		this.exp = readLong(buf);
		int heroInfoLength = readShort(buf);
		for (int heroInfoI = 0; heroInfoI < heroInfoLength; heroInfoI++) {
			if (readByte(buf) == 0) { 
				this.heroInfo.add(null);
			} else {
				HerosAttributeBean herosAttributeBean = new HerosAttributeBean();
				herosAttributeBean.read(buf);
				this.heroInfo.add(herosAttributeBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, level, false);
		this.writeInt(buf, reinLevel, false);
		this.writeLong(buf, exp);
		writeShort(buf, this.heroInfo.size());
		for (int heroInfoI = 0; heroInfoI < this.heroInfo.size(); heroInfoI++) {
			this.writeBean(buf, this.heroInfo.get(heroInfoI));
		}
		return true;
	}
}
