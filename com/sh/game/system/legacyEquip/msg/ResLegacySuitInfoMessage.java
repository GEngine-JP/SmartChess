package com.sh.game.system.legacyEquip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.legacyEquip.msg.bean.LegacySuitBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送传世装备套装信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLegacySuitInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLegacySuitInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 19001;
	}
	
	/**
	 * 套装列表
	 */
	private List<LegacySuitBean> legacySuitList = new ArrayList<>();

	public List<LegacySuitBean> getLegacySuitList() {
		return legacySuitList;
	}

	public void setLegacySuitList(List<LegacySuitBean> legacySuitList) {
		this.legacySuitList = legacySuitList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int legacySuitListLength = readShort(buf);
		for (int legacySuitListI = 0; legacySuitListI < legacySuitListLength; legacySuitListI++) {
			if (readByte(buf) == 0) { 
				this.legacySuitList.add(null);
			} else {
				LegacySuitBean legacySuitBean = new LegacySuitBean();
				legacySuitBean.read(buf);
				this.legacySuitList.add(legacySuitBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.legacySuitList.size());
		for (int legacySuitListI = 0; legacySuitListI < this.legacySuitList.size(); legacySuitListI++) {
			this.writeBean(buf, this.legacySuitList.get(legacySuitListI));
		}
		return true;
	}
}
