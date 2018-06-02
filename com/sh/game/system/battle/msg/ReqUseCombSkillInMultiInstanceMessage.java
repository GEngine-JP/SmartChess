package com.sh.game.system.battle.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>多人副本使用连击打怪</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqUseCombSkillInMultiInstanceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqUseCombSkillInMultiInstanceMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 25010;
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
