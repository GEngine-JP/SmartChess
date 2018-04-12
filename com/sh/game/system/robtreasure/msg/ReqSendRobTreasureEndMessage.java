package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>通知夺宝战斗结束</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqSendRobTreasureEndMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqSendRobTreasureEndMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50015;
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

