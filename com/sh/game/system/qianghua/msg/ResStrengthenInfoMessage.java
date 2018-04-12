package com.sh.game.system.qianghua.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.qianghua.msg.bean.StrengthenBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回强化信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResStrengthenInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResStrengthenInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 12002;
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
	 * 强化列表
	 */
	private List<StrengthenBean> strengthenList = new ArrayList<StrengthenBean>();


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

	
	public List<StrengthenBean> getStrengthenList() {
		return strengthenList;
	}

	public void setStrengthenList(List<StrengthenBean> strengthenList) {
		this.strengthenList = strengthenList;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.fightValue = readInt(buf, false);
		int strengthenListLength = readShort(buf);
		for (int strengthenListI = 0; strengthenListI < strengthenListLength; strengthenListI++) {
			if (readByte(buf) == 0) { 
				this.strengthenList.add(null);
			} else {
				StrengthenBean strengthenBean = new StrengthenBean();
				strengthenBean.read(buf);
				this.strengthenList.add(strengthenBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, fightValue, false);
		writeShort(buf, this.strengthenList.size());
		for (int strengthenListI = 0; strengthenListI < this.strengthenList.size(); strengthenListI++) {
			this.writeBean(buf, this.strengthenList.get(strengthenListI));
		}


		return true;
	}
}

