package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>在线人数</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqBackOnlineCountMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBackOnlineCountMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43035;
	}
	
	/**
	 * 当前时间
	 */
	private int time;


	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.time = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, time, false);

		return true;
	}
}

