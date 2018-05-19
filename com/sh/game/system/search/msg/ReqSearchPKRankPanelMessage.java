package com.sh.game.system.search.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求探索PK排名奖励面板</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqSearchPKRankPanelMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqSearchPKRankPanelMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 38010;
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
