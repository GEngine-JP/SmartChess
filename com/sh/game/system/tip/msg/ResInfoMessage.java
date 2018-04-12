package com.sh.game.system.tip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>提示</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 7001;
	}
	
	/**
	 * 信息
	 */
	private String info;


	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.info = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, info);

		return true;
	}
}

