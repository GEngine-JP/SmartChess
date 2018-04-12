package com.sh.game.system.chapter.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求进入挂机地图</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqHangUpMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqHangUpMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 41001;
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

