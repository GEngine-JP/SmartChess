package com.sh.game.system.xinfa.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求获取心法面板信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetHeartMethodPanelInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetHeartMethodPanelInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 58005;
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
