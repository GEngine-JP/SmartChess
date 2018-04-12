package com.sh.game.system.equip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.equip.msg.bean.EquipBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>所有装备信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResAllEquipMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAllEquipMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 13001;
	}
	
	/**
	 * 所有的装备信息
	 */
	private List<EquipBean> equipList = new ArrayList<EquipBean>();


	public List<EquipBean> getEquipList() {
		return equipList;
	}

	public void setEquipList(List<EquipBean> equipList) {
		this.equipList = equipList;
	}


	@Override
	public boolean read(KryoInput buf) {
		int equipListLength = readShort(buf);
		for (int equipListI = 0; equipListI < equipListLength; equipListI++) {
			if (readByte(buf) == 0) { 
				this.equipList.add(null);
			} else {
				EquipBean equipBean = new EquipBean();
				equipBean.read(buf);
				this.equipList.add(equipBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.equipList.size());
		for (int equipListI = 0; equipListI < this.equipList.size(); equipListI++) {
			this.writeBean(buf, this.equipList.get(equipListI));
		}


		return true;
	}
}

