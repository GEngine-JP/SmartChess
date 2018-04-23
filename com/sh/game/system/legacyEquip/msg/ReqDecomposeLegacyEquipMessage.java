package com.sh.game.system.legacyEquip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求分解传世装备</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqDecomposeLegacyEquipMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqDecomposeLegacyEquipMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 19006;
	}
	
	/**
	 * 唯一id
	 */
	private long uniqueId;

	public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.uniqueId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, uniqueId);
		return true;
	}
}
