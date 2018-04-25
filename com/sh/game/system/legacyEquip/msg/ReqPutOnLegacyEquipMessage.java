package com.sh.game.system.legacyEquip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求更换传世装备</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqPutOnLegacyEquipMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqPutOnLegacyEquipMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 19007;
	}
	
	/**
	 * 唯一id
	 */
	private long uniqueId;
	/**
	 * 装备位置
	 */
	private int index;
	/**
	 * 角色或英雄唯一id
	 */
	private long uid;

	public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

		public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

		public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.uniqueId = readLong(buf);
		this.index = readInt(buf, false);
		this.uid = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, uniqueId);
		this.writeInt(buf, index, false);
		this.writeLong(buf, uid);
		return true;
	}
}
