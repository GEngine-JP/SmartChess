package com.sh.game.system.fight.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>玩家挑战返回</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRoleChallengeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRoleChallengeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 25007;
	}
	
	/**
	 * 回合计数
	 */
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.count = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, count, false);
		return true;
	}
}
