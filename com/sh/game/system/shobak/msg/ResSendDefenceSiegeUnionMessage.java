package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送守城方行会信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendDefenceSiegeUnionMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendDefenceSiegeUnionMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40017;
	}
	
	/**
	 * 守城方行会id
	 */
	private long unionId;
	/**
	 * 守城方行会名
	 */
	private String unionName;
	/**
	 * 皇宫归属行会id
	 */
	private long ownerUnionId;
	/**
	 * 皇宫归属行会名
	 */
	private String ownerName;
	/**
	 * 皇宫是否开启
	 */
	private int openPalace;

	public long getUnionId() {
		return unionId;
	}

	public void setUnionId(long unionId) {
		this.unionId = unionId;
	}

		public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}

		public long getOwnerUnionId() {
		return ownerUnionId;
	}

	public void setOwnerUnionId(long ownerUnionId) {
		this.ownerUnionId = ownerUnionId;
	}

		public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

		public int getOpenPalace() {
		return openPalace;
	}

	public void setOpenPalace(int openPalace) {
		this.openPalace = openPalace;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.unionId = readLong(buf);
		this.unionName = readString(buf);
		this.ownerUnionId = readLong(buf);
		this.ownerName = readString(buf);
		this.openPalace = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, unionId);
		this.writeString(buf, unionName);
		this.writeLong(buf, ownerUnionId);
		this.writeString(buf, ownerName);
		this.writeInt(buf, openPalace, false);
		return true;
	}
}
