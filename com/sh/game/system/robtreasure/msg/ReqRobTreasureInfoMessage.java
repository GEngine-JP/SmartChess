package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求夺宝事件面板信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqRobTreasureInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRobTreasureInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50001;
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

