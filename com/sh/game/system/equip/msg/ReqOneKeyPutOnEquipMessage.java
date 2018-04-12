package com.sh.game.system.equip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>请求一键换装</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqOneKeyPutOnEquipMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOneKeyPutOnEquipMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 13002;
	}
	
	/**
	 * 位置
	 */
	private List<Integer> pos = new ArrayList<Integer>();

	/**
	 * 要换的装备列表
	 */
	private List<Long> uniqueId = new ArrayList<Long>();


	public List<Integer> getPos() {
		return pos;
	}

	public void setPos(List<Integer> pos) {
		this.pos = pos;
	}

	public List<Long> getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(List<Long> uniqueId) {
		this.uniqueId = uniqueId;
	}


	@Override
	public boolean read(KryoInput buf) {
		int posLength = readShort(buf);
		for (int posI = 0; posI < posLength; posI++) {
			this.pos.add(this.readInt(buf, false));
		}

		int uniqueIdLength = readShort(buf);
		for (int uniqueIdI = 0; uniqueIdI < uniqueIdLength; uniqueIdI++) {
			this.uniqueId.add(this.readLong(buf));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.pos.size());
		for (int posI = 0; posI < this.pos.size(); posI++) {
			this.writeInt(buf, this.pos.get(posI), false);
		}

		writeShort(buf, this.uniqueId.size());
		for (int uniqueIdI = 0; uniqueIdI < this.uniqueId.size(); uniqueIdI++) {
			this.writeLong(buf, this.uniqueId.get(uniqueIdI));
		}


		return true;
	}
}

