package com.sh.game.system.redenvelop.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回领取红包结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDrawRedEnvelopMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDrawRedEnvelopMessage() {
		this.queueId = 0;
	}
	
	@Override
	public int getId() {
		return 63003;
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
