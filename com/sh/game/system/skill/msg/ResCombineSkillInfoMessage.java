package com.sh.game.system.skill.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>合击技能前置条件信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResCombineSkillInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCombineSkillInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 9008;
	}
	
	/**
	 * 已激活的道具id集合
	 */
	private List<Integer> items = new ArrayList<>();
	/**
	 * 是否已激活 1激活
	 */
	private int isActive;

	public List<Integer> getItems() {
		return items;
	}

	public void setItems(List<Integer> items) {
		this.items = items;
	}
	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int itemsLength = readShort(buf);
		for (int itemsI = 0; itemsI < itemsLength; itemsI++) {
			this.items.add(this.readInt(buf, false));
		}		this.isActive = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.items.size());
		for (int itemsI = 0; itemsI < this.items.size(); itemsI++) {
			this.writeInt(buf, this.items.get(itemsI), false);
		}		this.writeInt(buf, isActive, false);
		return true;
	}
}
