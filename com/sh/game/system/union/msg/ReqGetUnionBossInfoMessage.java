package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求获取行会boss信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetUnionBossInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetUnionBossInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23027;
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

