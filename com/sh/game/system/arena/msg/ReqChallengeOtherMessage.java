package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求挑战其他玩家</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqChallengeOtherMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqChallengeOtherMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37003;
	}
	
	/**
	 * 目标玩家排名
	 */
	private int targetRank;

	/**
	 * 副本id
	 */
	private int instanceId;


	public int getTargetRank() {
		return targetRank;
	}

	public void setTargetRank(int targetRank) {
		this.targetRank = targetRank;
	}

	
	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.targetRank = readInt(buf, false);
		this.instanceId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, targetRank, false);
		this.writeInt(buf, instanceId, false);

		return true;
	}
}

