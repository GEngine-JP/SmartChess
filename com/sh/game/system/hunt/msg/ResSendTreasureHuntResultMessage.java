package com.sh.game.system.hunt.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.hunt.msg.bean.ItemInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回寻宝结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendTreasureHuntResultMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendTreasureHuntResultMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 11003;
	}
	
	/**
	 * 寻宝类型
	 */
	private int type;
	/**
	 *  寻宝获得的道具
	 */
	private List<ItemInfo> item = new ArrayList<>();
	/**
	 * 次数
	 */
	private int count;
	/**
	 * 寻宝次数
	 */
	private int huntCount;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public List<ItemInfo> getItem() {
		return item;
	}

	public void setItem(List<ItemInfo> item) {
		this.item = item;
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

		public int getHuntCount() {
		return huntCount;
	}

	public void setHuntCount(int huntCount) {
		this.huntCount = huntCount;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		int itemLength = readShort(buf);
		for (int itemI = 0; itemI < itemLength; itemI++) {
			if (readByte(buf) == 0) { 
				this.item.add(null);
			} else {
				ItemInfo itemInfo = new ItemInfo();
				itemInfo.read(buf);
				this.item.add(itemInfo);
			}
		}		this.count = readInt(buf, false);
		this.huntCount = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		writeShort(buf, this.item.size());
		for (int itemI = 0; itemI < this.item.size(); itemI++) {
			this.writeBean(buf, this.item.get(itemI));
		}		this.writeInt(buf, count, false);
		this.writeInt(buf, huntCount, false);
		return true;
	}
}
