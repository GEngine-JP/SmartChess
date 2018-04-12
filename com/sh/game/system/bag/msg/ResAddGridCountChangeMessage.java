package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>扩容次数变化的消息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResAddGridCountChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAddGridCountChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10008;
	}
	
	/**
	 * 背包装备页签扩容的次数
	 */
	private int addGridCount;

	/**
	 * 背包道具页签剩余空格的数量
	 */
	private int emptyItemGridCount;

	/**
	 * 背包装备页签剩余空格的数量
	 */
	private int emptyEquipGridCount;

	/**
	 * 背包装备页签总的格子的数量
	 */
	private int maxEquipGridCount;

	/**
	 * 符文剩余格子
	 */
	private int emptyRuneGridCount;

	/**
	 * 符文总格子
	 */
	private int maxRuneGridCount;


	public int getAddGridCount() {
		return addGridCount;
	}

	public void setAddGridCount(int addGridCount) {
		this.addGridCount = addGridCount;
	}

	
	public int getEmptyItemGridCount() {
		return emptyItemGridCount;
	}

	public void setEmptyItemGridCount(int emptyItemGridCount) {
		this.emptyItemGridCount = emptyItemGridCount;
	}

	
	public int getEmptyEquipGridCount() {
		return emptyEquipGridCount;
	}

	public void setEmptyEquipGridCount(int emptyEquipGridCount) {
		this.emptyEquipGridCount = emptyEquipGridCount;
	}

	
	public int getMaxEquipGridCount() {
		return maxEquipGridCount;
	}

	public void setMaxEquipGridCount(int maxEquipGridCount) {
		this.maxEquipGridCount = maxEquipGridCount;
	}

	
	public int getEmptyRuneGridCount() {
		return emptyRuneGridCount;
	}

	public void setEmptyRuneGridCount(int emptyRuneGridCount) {
		this.emptyRuneGridCount = emptyRuneGridCount;
	}

	
	public int getMaxRuneGridCount() {
		return maxRuneGridCount;
	}

	public void setMaxRuneGridCount(int maxRuneGridCount) {
		this.maxRuneGridCount = maxRuneGridCount;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.addGridCount = readInt(buf, false);
		this.emptyItemGridCount = readInt(buf, false);
		this.emptyEquipGridCount = readInt(buf, false);
		this.maxEquipGridCount = readInt(buf, false);
		this.emptyRuneGridCount = readInt(buf, false);
		this.maxRuneGridCount = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, addGridCount, false);
		this.writeInt(buf, emptyItemGridCount, false);
		this.writeInt(buf, emptyEquipGridCount, false);
		this.writeInt(buf, maxEquipGridCount, false);
		this.writeInt(buf, emptyRuneGridCount, false);
		this.writeInt(buf, maxRuneGridCount, false);

		return true;
	}
}

