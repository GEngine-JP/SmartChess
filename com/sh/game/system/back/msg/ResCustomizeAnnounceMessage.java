package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送自定义公告(后台用)</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResCustomizeAnnounceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCustomizeAnnounceMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43023;
	}
	
	/**
	 * 类型
	 */
	private int type;

	/**
	 * 内容
	 */
	private String content;


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.content = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeString(buf, content);

		return true;
	}
}

