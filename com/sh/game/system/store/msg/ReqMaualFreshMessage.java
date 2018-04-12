package com.sh.game.system.store.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求手动刷新</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqMaualFreshMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqMaualFreshMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 16007;
	}
	
	/**
	 * storeClassId
	 */
	private int storeClassId;


	public int getStoreClassId() {
		return storeClassId;
	}

	public void setStoreClassId(int storeClassId) {
		this.storeClassId = storeClassId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.storeClassId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, storeClassId, false);

		return true;
	}
}

