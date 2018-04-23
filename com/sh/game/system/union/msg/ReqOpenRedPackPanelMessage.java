package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>打开红包面板</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqOpenRedPackPanelMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOpenRedPackPanelMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23039;
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
