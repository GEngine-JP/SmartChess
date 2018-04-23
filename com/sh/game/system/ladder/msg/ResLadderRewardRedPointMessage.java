package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>小红点</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLadderRewardRedPointMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLadderRewardRedPointMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5017;
	}
	
	/**
	 * 1 有 0 没有
	 */
	private int ifHad;

	public int getIfHad() {
		return ifHad;
	}

	public void setIfHad(int ifHad) {
		this.ifHad = ifHad;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.ifHad = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, ifHad, false);
		return true;
	}
}
