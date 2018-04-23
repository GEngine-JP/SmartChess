package com.sh.game.system.runes.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求穿戴指定符文</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqPutOnTheRuneMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqPutOnTheRuneMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 24008;
	}
	
	/**
	 * 装备位置
	 */
	private int index;
	/**
	 * 要穿戴的符文唯一id
	 */
	private long uniqueId;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

		public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.index = readInt(buf, false);
		this.uniqueId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, index, false);
		this.writeLong(buf, uniqueId);
		return true;
	}
}
