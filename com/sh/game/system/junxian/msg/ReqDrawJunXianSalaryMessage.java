package com.sh.game.system.junxian.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求领取军衔俸禄</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqDrawJunXianSalaryMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqDrawJunXianSalaryMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 59004;
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
