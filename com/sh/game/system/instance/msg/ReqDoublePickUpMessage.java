package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求双倍拾取个人Boss物品</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqDoublePickUpMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqDoublePickUpMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20031;
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
