package com.sh.game.system.king.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送王者禁地排行面板信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqKingForbiddenRankPanelMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqKingForbiddenRankPanelMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 45002;
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
