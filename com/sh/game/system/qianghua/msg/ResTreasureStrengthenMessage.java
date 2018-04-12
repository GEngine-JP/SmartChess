package com.sh.game.system.qianghua.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.qianghua.msg.bean.StrengthenBean;


/**
 * <p>强化改变信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResTreasureStrengthenMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResTreasureStrengthenMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 12006;
	}
	
	/**
	 * 类型 1角色强化 2英雄强化
	 */
	private int type;

	/**
	 * 英雄id
	 */
	private long heroId;

	/**
	 * 结果 1成功 2失败 3降级
	 */
	private int result;

	/**
	 * 战斗力
	 */
	private int fightValue;

	/**
	 * 强化结果
	 */
	private StrengthenBean strengthenBean;


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

	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	
	public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	public StrengthenBean getStrengthenBean() {
		return strengthenBean;
	}

	public void setStrengthenBean(StrengthenBean strengthenBean) {
		this.strengthenBean = strengthenBean;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.result = readInt(buf, false);
		this.fightValue = readInt(buf, false);
		if (readByte(buf) != 0) {
			StrengthenBean strengthenBean = new StrengthenBean();
			strengthenBean.read(buf);
			this.strengthenBean = strengthenBean;
		}

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, result, false);
		this.writeInt(buf, fightValue, false);
		this.writeBean(buf, strengthenBean);

		return true;
	}
}

