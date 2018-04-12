package com.sh.game.system.skill.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求激活合击技能</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqActiveCombineSkillMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqActiveCombineSkillMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 9009;
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

