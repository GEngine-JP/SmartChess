package com.sh.game.system.hunt.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.hunt.msg.bean.ItemInfo;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回寻宝仓库装备信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendTreasureHuntWareHouseInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendTreasureHuntWareHouseInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 11005;
	}
	
	/**
	 * 装备信息
	 */
	private List<ItemInfo> item = new ArrayList<ItemInfo>();


	public List<ItemInfo> getItem() {
		return item;
	}

	public void setItem(List<ItemInfo> item) {
		this.item = item;
	}


	@Override
	public boolean read(KryoInput buf) {
		int itemLength = readShort(buf);
		for (int itemI = 0; itemI < itemLength; itemI++) {
			if (readByte(buf) == 0) { 
				this.item.add(null);
			} else {
				ItemInfo itemInfo = new ItemInfo();
				itemInfo.read(buf);
				this.item.add(itemInfo);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.item.size());
		for (int itemI = 0; itemI < this.item.size(); itemI++) {
			this.writeBean(buf, this.item.get(itemI));
		}


		return true;
	}
}

