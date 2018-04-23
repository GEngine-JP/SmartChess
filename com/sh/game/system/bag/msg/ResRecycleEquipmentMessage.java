package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>回收装备</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRecycleEquipmentMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRecycleEquipmentMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10009;
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
