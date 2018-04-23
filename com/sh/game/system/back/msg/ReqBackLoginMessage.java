package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>通过后台登录</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqBackLoginMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBackLoginMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43021;
	}
	
	/**
	 * 玩家登录账号
	 */
	private String loginName;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.loginName = readString(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeString(buf, loginName);
		return true;
	}
}
