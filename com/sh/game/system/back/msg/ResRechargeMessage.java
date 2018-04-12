package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回请求充值结果</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResRechargeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRechargeMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43020;
	}
	
	/**
	 * 玩家登录账号
	 */
	private String loginName;

	/**
	 * 返回码
	 */
	private int code;

	/**
	 * 原因
	 */
	private String msg;

	/**
	 * 元宝数量
	 */
	private int count;

	/**
	 * 0、充值元宝 1、绑定元宝
	 */
	private int type;


	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.loginName = readString(buf);
		this.code = readInt(buf, false);
		this.msg = readString(buf);
		this.count = readInt(buf, false);
		this.type = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, loginName);
		this.writeInt(buf, code, false);
		this.writeString(buf, msg);
		this.writeInt(buf, count, false);
		this.writeInt(buf, type, false);

		return true;
	}
}

