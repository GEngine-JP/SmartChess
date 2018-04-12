package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发红包</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqSendUnionRedPackMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqSendUnionRedPackMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23036;
	}
	
	/**
	 * 元宝数
	 */
	private int money;

	/**
	 * 文字内容
	 */
	private String content;

	/**
	 * 个数
	 */
	private int count;


	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.money = readInt(buf, false);
		this.content = readString(buf);
		this.count = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, money, false);
		this.writeString(buf, content);
		this.writeInt(buf, count, false);

		return true;
	}
}

