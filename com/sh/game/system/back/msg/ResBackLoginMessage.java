package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>后台登录结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResBackLoginMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResBackLoginMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43022;
	}
	
	/**
	 * 登录结果 1成功 2失败
	 */
	private int loginRet;

	public int getLoginRet() {
		return loginRet;
	}

	public void setLoginRet(int loginRet) {
		this.loginRet = loginRet;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.loginRet = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, loginRet, false);
		return true;
	}
}
