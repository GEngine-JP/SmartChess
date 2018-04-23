package com.sh.game.system.wing.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.wing.msg.bean.WingEquipBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送光翼装备信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResWingEquipInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResWingEquipInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 18006;
	}
	
	/**
	 * 1角色光翼 2英雄光翼
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
	 * 光翼装备列表
	 */
	private List<WingEquipBean> wingEquipList = new ArrayList<>();

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

		public List<WingEquipBean> getWingEquipList() {
		return wingEquipList;
	}

	public void setWingEquipList(List<WingEquipBean> wingEquipList) {
		this.wingEquipList = wingEquipList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.fightValue = readInt(buf, false);
		int wingEquipListLength = readShort(buf);
		for (int wingEquipListI = 0; wingEquipListI < wingEquipListLength; wingEquipListI++) {
			if (readByte(buf) == 0) { 
				this.wingEquipList.add(null);
			} else {
				WingEquipBean wingEquipBean = new WingEquipBean();
				wingEquipBean.read(buf);
				this.wingEquipList.add(wingEquipBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, fightValue, false);
		writeShort(buf, this.wingEquipList.size());
		for (int wingEquipListI = 0; wingEquipListI < this.wingEquipList.size(); wingEquipListI++) {
			this.writeBean(buf, this.wingEquipList.get(wingEquipListI));
		}
		return true;
	}
}
