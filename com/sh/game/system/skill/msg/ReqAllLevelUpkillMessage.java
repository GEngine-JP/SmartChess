package com.sh.game.system.skill.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求全部升级技能</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqAllLevelUpkillMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqAllLevelUpkillMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 9004;
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
