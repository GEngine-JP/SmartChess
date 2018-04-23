package com.sh.game.system.fcm.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求认证</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqAuthorityMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqAuthorityMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 34002;
	}
	
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 身份证号
	 */
	private String idNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.name = readString(buf);
		this.idNumber = readString(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeString(buf, name);
		this.writeString(buf, idNumber);
		return true;
	}
}
