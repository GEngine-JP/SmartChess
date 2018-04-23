package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>爱微游关注奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResAiWeiYouFocusMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAiWeiYouFocusMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44004;
	}
	
	/**
	 * 1为成功
	 */
	private int reward;

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.reward = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, reward, false);
		return true;
	}
}
