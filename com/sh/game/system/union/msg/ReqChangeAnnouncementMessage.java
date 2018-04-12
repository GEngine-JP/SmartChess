package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>申请修改公告</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqChangeAnnouncementMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqChangeAnnouncementMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23006;
	}
	
	/**
	 * 新帮会公告
	 */
	private String announcement;


	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.announcement = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, announcement);

		return true;
	}
}

