package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>后台修改配置文件</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqChangePropertyMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqChangePropertyMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43013;
	}
	
	/**
	 * 键
	 */
	private String key;
	/**
	 * 值
	 */
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

		public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.key = readString(buf);
		this.value = readString(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeString(buf, key);
		this.writeString(buf, value);
		return true;
	}
}
