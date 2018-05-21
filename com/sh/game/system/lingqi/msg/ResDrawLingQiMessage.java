package com.sh.game.system.lingqi.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回领取灵器结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDrawLingQiMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDrawLingQiMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 61002;
	}
	
	/**
	 * 灵器id
	 */
	private int lingQiId;

	public int getLingQiId() {
		return lingQiId;
	}

	public void setLingQiId(int lingQiId) {
		this.lingQiId = lingQiId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.lingQiId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, lingQiId, false);
		return true;
	}
}
