package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回请求结果（后台用）</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendEmailMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendEmailMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43012;
	}
	
	/**
	 * 收件人id
	 */
	private long targetId;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 附件
	 */
	private String itemStr;


	public long getTargetId() {
		return targetId;
	}

	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public String getItemStr() {
		return itemStr;
	}

	public void setItemStr(String itemStr) {
		this.itemStr = itemStr;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.targetId = readLong(buf);
		this.title = readString(buf);
		this.content = readString(buf);
		this.itemStr = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, targetId);
		this.writeString(buf, title);
		this.writeString(buf, content);
		this.writeString(buf, itemStr);

		return true;
	}
}

