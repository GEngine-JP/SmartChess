package com.sh.game.system.fight.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>合击技能触发符文效果</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResCombineSkillTriggerRunesMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCombineSkillTriggerRunesMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 25012;
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

