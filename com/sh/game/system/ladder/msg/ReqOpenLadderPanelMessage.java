package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>打开天梯面板</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqOpenLadderPanelMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOpenLadderPanelMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5008;
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

