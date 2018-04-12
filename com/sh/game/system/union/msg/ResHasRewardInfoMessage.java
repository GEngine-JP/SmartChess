package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>是否有奖励角标</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResHasRewardInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHasRewardInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23025;
	}
	
	/**
	 * 有奖励的提示 1
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

