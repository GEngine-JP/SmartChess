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
	 * 点数
	 */
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.count = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, count, false);
		return true;
	}
}
