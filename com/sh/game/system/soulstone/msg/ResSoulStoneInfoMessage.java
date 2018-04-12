package com.sh.game.system.soulstone.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.soulstone.msg.bean.SoulStoneBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回魂石信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSoulStoneInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSoulStoneInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 35012;
	}
	
	/**
	 * 类型 1角色 2英雄
	 */
	private int type;

	/**
	 * 英雄id
	 */
	private long heroId;

	/**
	 * 战斗力
	 */
	private int fightValue;

	/**
	 * 魂石列表
	 */
	private List<SoulStoneBean> soulStoneList = new ArrayList<SoulStoneBean>();


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

	
	public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	public List<SoulStoneBean> getSoulStoneList() {
		return soulStoneList;
	}

	public void setSoulStoneList(List<SoulStoneBean> soulStoneList) {
		this.soulStoneList = soulStoneList;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.fightValue = readInt(buf, false);
		int soulStoneListLength = readShort(buf);
		for (int soulStoneListI = 0; soulStoneListI < soulStoneListLength; soulStoneListI++) {
			if (readByte(buf) == 0) { 
				this.soulStoneList.add(null);
			} else {
				SoulStoneBean soulStoneBean = new SoulStoneBean();
				soulStoneBean.read(buf);
				this.soulStoneList.add(soulStoneBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, fightValue, false);
		writeShort(buf, this.soulStoneList.size());
		for (int soulStoneListI = 0; soulStoneListI < this.soulStoneList.size(); soulStoneListI++) {
			this.writeBean(buf, this.soulStoneList.get(soulStoneListI));
		}


		return true;
	}
}

