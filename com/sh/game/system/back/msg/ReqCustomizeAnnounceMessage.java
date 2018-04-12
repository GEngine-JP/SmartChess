package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求发送自定义公告(后台用)</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqCustomizeAnnounceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqCustomizeAnnounceMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43009;
	}
	
	/**
	 * 唯一自增id
	 */
	private int uniqueId;

	/**
	 * 开始时间
	 */
	private int startTime;

	/**
	 * 结束时间
	 */
	private int endTime;

	/**
	 * 间隔
	 */
	private int period;

	/**
	 * 类型
	 */
	private int type;

	/**
	 * 内容
	 */
	private String content;


	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	
	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	
	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	
	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	
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
		this.uniqueId = readInt(buf, false);
		this.startTime = readInt(buf, false);
		this.endTime = readInt(buf, false);
		this.period = readInt(buf, false);
		this.type = readInt(buf, false);
		this.content = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, uniqueId, false);
		this.writeInt(buf, startTime, false);
		this.writeInt(buf, endTime, false);
		this.writeInt(buf, period, false);
		this.writeInt(buf, type, false);
		this.writeString(buf, content);

		return true;
	}
}

