package com.sh.game.system.treasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.treasure.msg.bean.TreasureBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回所有宝物信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHeroAllTreasureInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroAllTreasureInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 14015;
	}
	
	/**
	 * 所有宝物信息
	 */
	private List<TreasureBean> treasureList = new ArrayList<>();

	public List<TreasureBean> getTreasureList() {
		return treasureList;
	}

	public void setTreasureList(List<TreasureBean> treasureList) {
		this.treasureList = treasureList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int treasureListLength = readShort(buf);
		for (int treasureListI = 0; treasureListI < treasureListLength; treasureListI++) {
			if (readByte(buf) == 0) { 
				this.treasureList.add(null);
			} else {
				TreasureBean treasureBean = new TreasureBean();
				treasureBean.read(buf);
				this.treasureList.add(treasureBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.treasureList.size());
		for (int treasureListI = 0; treasureListI < this.treasureList.size(); treasureListI++) {
			this.writeBean(buf, this.treasureList.get(treasureListI));
		}
		return true;
	}
}
