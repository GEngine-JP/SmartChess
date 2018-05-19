package com.sh.game.system.fight.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>怪物死亡通知</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqMonsterDieMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqMonsterDieMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 25005;
	}
	
	/**
	 * 怪物id
	 */
	private int monsterId;

	public int getMonsterId() {
		return monsterId;
	}

	public void setMonsterId(int monsterId) {
		this.monsterId = monsterId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.monsterId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, monsterId, false);
		return true;
	}
}
