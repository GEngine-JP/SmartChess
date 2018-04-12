package com.sh.game.system.equip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.equip.msg.bean.EquipsChange;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>装备信息更新</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResEquipChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResEquipChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 13005;
	}
	
	/**
	 * 更换的装备
	 */
	private List<EquipsChange> equipChange = new ArrayList<EquipsChange>();


	public List<EquipsChange> getEquipChange() {
		return equipChange;
	}

	public void setEquipChange(List<EquipsChange> equipChange) {
		this.equipChange = equipChange;
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
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.equipChange.size());
		for (int equipChangeI = 0; equipChangeI < this.equipChange.size(); equipChangeI++) {
			this.writeBean(buf, this.equipChange.get(equipChangeI));
		}


		return true;
	}
}

