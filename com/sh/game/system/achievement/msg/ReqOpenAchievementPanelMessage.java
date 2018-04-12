package com.sh.game.system.achievement.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>打开成就面板</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqOpenAchievementPanelMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOpenAchievementPanelMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 17003;
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

