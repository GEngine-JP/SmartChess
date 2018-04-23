package com.sh.game.system.email.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class EmailInfo extends KryoBean {

	/**
	 * 邮件的id
	 */
	private long emailId;
	/**
	 * 邮件标题
	 */
	private String title;
	/**
	 * 邮件内容
	 */
	private String desc;
	/**
	 * 附件
	 */
	private String items;
	/**
	 * 邮件状态0未读 1 已读 2 已提取
	 */
	private int state;
	/**
	 * 邮件发送时间
	 */
	private int time;

	public long getEmailId() {
		return emailId;
	}

	public void setEmailId(long emailId) {
		this.emailId = emailId;
	}

		public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

		public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

		public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

		public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

		public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.emailId = readLong(buf);
		this.title = readString(buf);
		this.desc = readString(buf);
		this.items = readString(buf);
		this.state = readInt(buf, false);
		this.time = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, emailId);
		this.writeString(buf, title);
		this.writeString(buf, desc);
		this.writeString(buf, items);
		this.writeInt(buf, state, false);
		this.writeInt(buf, time, false);
		return true;
	}
}
