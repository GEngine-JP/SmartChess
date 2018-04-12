package com.sh.game.system.logingift.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求领取奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetLoginGiftMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetLoginGiftMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 2001;
	}
	
	/**
	 * 配置表id
	 */
	private int loginDay;


	public int getLoginDay() {
		return loginDay;
	}

	public void setLoginDay(int loginDay) {
		this.loginDay = loginDay;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.loginDay = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, loginDay, false);

		return true;
	}
}

