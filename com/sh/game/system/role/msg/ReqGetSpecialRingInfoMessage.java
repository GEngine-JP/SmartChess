package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求获取特戒信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetSpecialRingInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetSpecialRingInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8017;
	}
	


	@Override
	public boolean read(KryoInput buf) {

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		return true;
	}
}

