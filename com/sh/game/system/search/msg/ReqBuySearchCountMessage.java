package com.sh.game.system.search.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求购买探索次数</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqBuySearchCountMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBuySearchCountMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 38004;
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
