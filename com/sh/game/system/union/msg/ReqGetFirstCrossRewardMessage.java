package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>领取行会挑战首通奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetFirstCrossRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetFirstCrossRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23042;
	}
	
	/**
	 * 领取的关数
	 */
	private int floorId;


	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.floorId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, floorId, false);

		return true;
	}
}

