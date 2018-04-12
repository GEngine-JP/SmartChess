package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>爱微游鉴权</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResAiWeiYouAuthMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAiWeiYouAuthMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44004;
	}
	
	/**
	 * 0成功 其他为失败
	 */
	private int code;

	/**
	 * 1为成功
	 */
	private int reward;


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.code = readInt(buf, false);
		this.reward = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, code, false);
		this.writeInt(buf, reward, false);

		return true;
	}
}

