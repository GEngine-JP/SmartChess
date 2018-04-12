package com.sh.game.system.chat.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求GM命令</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGMMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGMMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 6001;
	}
	
	/**
	 * gm命令
	 */
	private String command;


	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.command = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, command);

		return true;
	}
}

