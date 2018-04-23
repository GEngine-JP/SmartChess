package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>通过后台全服登录</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqSendServerMailMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqSendServerMailMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43024;
	}
	
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
	/**
	 * 类型 1所有人 2等级 3充值的元宝数量
	 */
	private int type;
	/**
	 * 参数
	 */
	private int filterParam;

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

		public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public int getFilterParam() {
		return filterParam;
	}

	public void setFilterParam(int filterParam) {
		this.filterParam = filterParam;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.title = readString(buf);
		this.content = readString(buf);
		this.itemStr = readString(buf);
		this.type = readInt(buf, false);
		this.filterParam = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeString(buf, title);
		this.writeString(buf, content);
		this.writeString(buf, itemStr);
		this.writeInt(buf, type, false);
		this.writeInt(buf, filterParam, false);
		return true;
	}
}
