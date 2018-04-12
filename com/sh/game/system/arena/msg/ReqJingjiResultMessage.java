package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求竞技结果</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqJingjiResultMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqJingjiResultMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37005;
	}
	
	/**
	 * 目标玩家排名
	 */
	private int targetRank;

	/**
	 * 副本唯一id
	 */
	private int uniqueId;


	public int getTargetRank() {
		return targetRank;
	}

	public void setTargetRank(int targetRank) {
		this.targetRank = targetRank;
	}

	
	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.targetRank = readInt(buf, false);
		this.uniqueId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, targetRank, false);
		this.writeInt(buf, uniqueId, false);

		return true;
	}
}

