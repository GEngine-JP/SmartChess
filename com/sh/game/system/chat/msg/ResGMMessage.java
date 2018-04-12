package com.sh.game.system.chat.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回GM命令执行结果</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResGMMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResGMMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 6002;
	}
	
	/**
	 * 执行结果
	 */
	private String content;


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.content = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, content);

		return true;
	}
}

