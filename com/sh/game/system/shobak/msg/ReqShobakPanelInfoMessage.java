package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求获取龙城争霸面板信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqShobakPanelInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqShobakPanelInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40003;
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
