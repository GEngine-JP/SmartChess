package com.sh.game.system.welfare.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求签到领奖</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetSignRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetSignRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 27002;
	}
	
	/**
	 * 签到奖励id
	 */
	private int rewardId;
	/**
	 * 类型 1第一次领取 2再次领取
	 */
	private int type;

	public int getRewardId() {
		return rewardId;
	}

	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}

		public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.rewardId = readInt(buf, false);
		this.type = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, rewardId, false);
		this.writeInt(buf, type, false);
		return true;
	}
}
