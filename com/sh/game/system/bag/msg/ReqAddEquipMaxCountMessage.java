package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>增加装备页签格子上限消息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqAddEquipMaxCountMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqAddEquipMaxCountMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10006;
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

