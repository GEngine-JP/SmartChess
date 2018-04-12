package com.sh.game.system.task.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回精英任务星级变化消息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendEliteInstanceStarChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendEliteInstanceStarChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 42003;
	}
	
	/**
	 * 精英任务最新星级
	 */
	private int starLevel;


	public int getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(int starLevel) {
		this.starLevel = starLevel;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.starLevel = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, starLevel, false);

		return true;
	}
}

