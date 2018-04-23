package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>后台改变会长</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqBackChangeUnionMasterMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBackChangeUnionMasterMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43044;
	}
	
	/**
	 * unionId
	 */
	private long unionId;
	/**
	 * uid
	 */
	private long uid;

	public long getUnionId() {
		return unionId;
	}

	public void setUnionId(long unionId) {
		this.unionId = unionId;
	}

		public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.unionId = readLong(buf);
		this.uid = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, unionId);
		this.writeLong(buf, uid);
		return true;
	}
}
