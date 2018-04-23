package com.sh.game.system.equip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.equip.msg.bean.EquipsChange;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>英雄装备信息更新</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHeroEquipChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroEquipChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 13006;
	}
	
	/**
	 * 更换的装备
	 */
	private List<EquipsChange> equipChange = new ArrayList<>();
	/**
	 * 英雄的id
	 */
	private long heroId;

	public List<EquipsChange> getEquipChange() {
		return equipChange;
	}

	public void setEquipChange(List<EquipsChange> equipChange) {
		this.equipChange = equipChange;
	}
	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int equipChangeLength = readShort(buf);
		for (int equipChangeI = 0; equipChangeI < equipChangeLength; equipChangeI++) {
			if (readByte(buf) == 0) { 
				this.equipChange.add(null);
			} else {
				EquipsChange equipsChange = new EquipsChange();
				equipsChange.read(buf);
				this.equipChange.add(equipsChange);
			}
		}		this.heroId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.equipChange.size());
		for (int equipChangeI = 0; equipChangeI < this.equipChange.size(); equipChangeI++) {
			this.writeBean(buf, this.equipChange.get(equipChangeI));
		}		this.writeLong(buf, heroId);
		return true;
	}
}
