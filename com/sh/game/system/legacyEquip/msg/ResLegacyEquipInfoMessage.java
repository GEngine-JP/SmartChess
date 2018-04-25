package com.sh.game.system.legacyEquip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.legacyEquip.msg.bean.LegacyEquipBean;

/**
 * <p>返回传世装备信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLegacyEquipInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLegacyEquipInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 19002;
	}
	
	/**
	 * 传世装备
	 */
	private LegacyEquipBean legacyEquipBean;
	/**
	 * 传世装备总战斗力
	 */
	private int fightValue;

	public LegacyEquipBean getLegacyEquipBean() {
		return legacyEquipBean;
	}

	public void setLegacyEquipBean(LegacyEquipBean legacyEquipBean) {
		this.legacyEquipBean = legacyEquipBean;
	}

		public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			LegacyEquipBean legacyEquipBean = new LegacyEquipBean();
			legacyEquipBean.read(buf);
			this.legacyEquipBean = legacyEquipBean;
		}
		this.fightValue = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, legacyEquipBean);
		this.writeInt(buf, fightValue, false);
		return true;
	}
}
