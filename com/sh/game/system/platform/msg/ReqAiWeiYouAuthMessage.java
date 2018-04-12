package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>爱微游鉴权</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqAiWeiYouAuthMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqAiWeiYouAuthMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44003;
	}
	
	/**
	 * token
	 */
	private String token;

	/**
	 * 是否关注公从号0否1是
	 */
	private int focus;


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	public int getFocus() {
		return focus;
	}

	public void setFocus(int focus) {
		this.focus = focus;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.token = readString(buf);
		this.focus = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, token);
		this.writeInt(buf, focus, false);

		return true;
	}
}

