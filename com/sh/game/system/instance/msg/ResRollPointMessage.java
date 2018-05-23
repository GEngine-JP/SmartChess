package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回roll点结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRollPointMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRollPointMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20035;
	}
	
	/**
	 * 领取倍数
	 */
	private int times;

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.times = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, times, false);
		return true;
	}
}
