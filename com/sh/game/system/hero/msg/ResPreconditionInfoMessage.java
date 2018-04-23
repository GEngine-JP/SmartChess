package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>创建英雄前置条件信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResPreconditionInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResPreconditionInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22019;
	}
	
	/**
	 * 已激活的道具id集合
	 */
	private List<Integer> itemIds = new ArrayList<>();

	public List<Integer> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<Integer> itemIds) {
		this.itemIds = itemIds;
	}

	@Override
	public boolean read(KryoInput buf) {

		int itemIdsLength = readShort(buf);
		for (int itemIdsI = 0; itemIdsI < itemIdsLength; itemIdsI++) {
			this.itemIds.add(this.readInt(buf, false));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.itemIds.size());
		for (int itemIdsI = 0; itemIdsI < this.itemIds.size(); itemIdsI++) {
			this.writeInt(buf, this.itemIds.get(itemIdsI), false);
		}
		return true;
	}
}
