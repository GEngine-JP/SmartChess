package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>是否有申请角标</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHasApplyInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHasApplyInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23026;
	}
	
	/**
	 * 申请提示 1 
	 */
	private int apply;

	public int getApply() {
		return apply;
	}

	public void setApply(int apply) {
		this.apply = apply;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.apply = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, apply, false);
		return true;
	}
}
