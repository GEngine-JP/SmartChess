package com.sh.game.system.hunt.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求开始寻宝</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqStartTreasureHuntMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqStartTreasureHuntMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 11002;
	}
	
	/**
	 * 寻宝次数
	 */
	private int num;


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.num = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, num, false);

		return true;
	}
}

