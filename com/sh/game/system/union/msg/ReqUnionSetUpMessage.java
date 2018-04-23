package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求设置帮会按钮</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqUnionSetUpMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqUnionSetUpMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23023;
	}
	
	/**
	 * 设置类型
	 */
	private int type;
	/**
	 * 设置值 1为true,0为false
	 */
	private int value;
	/**
	 * 设置的参数
	 */
	private int extraParam;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

		public int getExtraParam() {
		return extraParam;
	}

	public void setExtraParam(int extraParam) {
		this.extraParam = extraParam;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.value = readInt(buf, false);
		this.extraParam = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeInt(buf, value, false);
		this.writeInt(buf, extraParam, false);
		return true;
	}
}
