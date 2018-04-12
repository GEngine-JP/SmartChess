package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送雕像死亡倒计时</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendStatusDieTimeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendStatusDieTimeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40019;
	}
	
	/**
	 * 倒计时
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

