package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>后台修改行会公告</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqBackChangeUnionAnnounceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBackChangeUnionAnnounceMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43045;
	}
	
	/**
	 * uid
	 */
	private long uid;
	/**
	 * 公告内容
	 */
	private String content;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

		public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.uid = readLong(buf);
		this.content = readString(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, uid);
		this.writeString(buf, content);
		return true;
	}
}
