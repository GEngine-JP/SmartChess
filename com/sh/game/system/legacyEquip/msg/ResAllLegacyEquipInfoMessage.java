package com.sh.game.system.legacyEquip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.legacyEquip.msg.bean.LegacyEquipBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回所有传世装备信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResAllLegacyEquipInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAllLegacyEquipInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 19005;
	}
	
	/**
	 * 传世装备列表
	 */
	private List<LegacyEquipBean> legacyEquipList = new ArrayList<LegacyEquipBean>();

	/**
	 * 战斗力
	 */
	private int fightValue;


	public List<LegacyEquipBean> getLegacyEquipList() {
		return legacyEquipList;
	}

	public void setLegacyEquipList(List<LegacyEquipBean> legacyEquipList) {
		this.legacyEquipList = legacyEquipList;
	}

	public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		int legacyEquipListLength = readShort(buf);
		for (int legacyEquipListI = 0; legacyEquipListI < legacyEquipListLength; legacyEquipListI++) {
			if (readByte(buf) == 0) { 
				this.legacyEquipList.add(null);
			} else {
				LegacyEquipBean legacyEquipBean = new LegacyEquipBean();
				legacyEquipBean.read(buf);
				this.legacyEquipList.add(legacyEquipBean);
			}
		}

		this.fightValue = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.legacyEquipList.size());
		for (int legacyEquipListI = 0; legacyEquipListI < this.legacyEquipList.size(); legacyEquipListI++) {
			this.writeBean(buf, this.legacyEquipList.get(legacyEquipListI));
		}

		this.writeInt(buf, fightValue, false);

		return true;
	}
}

