package com.sh.game.system.chapter.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求主动改变地图</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqStageChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqStageChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 41015;
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

