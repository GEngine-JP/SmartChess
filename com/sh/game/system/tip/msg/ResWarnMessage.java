package com.sh.game.system.tip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>警告</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResWarnMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResWarnMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 7002;
	}
	
	/**
	 * 信息
	 */
	private String warn;

	public String getWarn() {
		return warn;
	}

	public void setWarn(String warn) {
		this.warn = warn;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.warn = readString(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeString(buf, warn);
		return true;
	}
}
