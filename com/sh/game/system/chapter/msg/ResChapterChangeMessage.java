package com.sh.game.system.chapter.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>关卡副本变化消息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResChapterChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResChapterChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 41014;
	}
	
	/**
	 * 关卡id
	 */
	private int stageId;


	public int getStageId() {
		return stageId;
	}

	public void setStageId(int stageId) {
		this.stageId = stageId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.stageId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, stageId, false);

		return true;
	}
}

