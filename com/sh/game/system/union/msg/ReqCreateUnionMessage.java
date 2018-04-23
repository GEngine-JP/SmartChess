package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>申请创建帮会</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqCreateUnionMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqCreateUnionMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23004;
	}
	
	/**
	 * 帮会名
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.name = readString(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeString(buf, name);
		return true;
	}
}
