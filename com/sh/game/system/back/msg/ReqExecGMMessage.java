package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求执行GM命令</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqExecGMMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqExecGMMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43003;
	}
	
	/**
	 * 命令
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
