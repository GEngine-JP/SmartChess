package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送修改公告信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendChangeAnnounceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendChangeAnnounceMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23016;
	}
	
	/**
	 * 调整后的公告
	 */
	private String announce;


	public String getAnnounce() {
		return announce;
	}

	public void setAnnounce(String announce) {
		this.announce = announce;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.announce = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, announce);

		return true;
	}
}

