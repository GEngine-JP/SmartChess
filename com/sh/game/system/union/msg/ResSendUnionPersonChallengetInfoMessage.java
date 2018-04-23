package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送行会个人挑战信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendUnionPersonChallengetInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendUnionPersonChallengetInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23030;
	}
	
	/**
	 * 本关怪物消减
	 */
	private int currentMonsterWeaken;
	/**
	 * 自已当前的关卡
	 */
	private int currentFloor;
	/**
	 * 副本Id
	 */
	private int instanceId;
	/**
	 * 空为没人通关 其余为通关玩家的名字
	 */
	private String firstSuccess;
	/**
	 * 达到的最大关数的副本id
	 */
	private int lifeMaxInstanceId;
	/**
	 * 当前可领取首通奖励副本id
	 */
	private int firstRewardInstanceId;
	/**
	 * 今日重置次數
	 */
	private int resetCount;

	public int getCurrentMonsterWeaken() {
		return currentMonsterWeaken;
	}

	public void setCurrentMonsterWeaken(int currentMonsterWeaken) {
		this.currentMonsterWeaken = currentMonsterWeaken;
	}

		public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

		public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

		public String getFirstSuccess() {
		return firstSuccess;
	}

	public void setFirstSuccess(String firstSuccess) {
		this.firstSuccess = firstSuccess;
	}

		public int getLifeMaxInstanceId() {
		return lifeMaxInstanceId;
	}

	public void setLifeMaxInstanceId(int lifeMaxInstanceId) {
		this.lifeMaxInstanceId = lifeMaxInstanceId;
	}

		public int getFirstRewardInstanceId() {
		return firstRewardInstanceId;
	}

	public void setFirstRewardInstanceId(int firstRewardInstanceId) {
		this.firstRewardInstanceId = firstRewardInstanceId;
	}

		public int getResetCount() {
		return resetCount;
	}

	public void setResetCount(int resetCount) {
		this.resetCount = resetCount;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.currentMonsterWeaken = readInt(buf, false);
		this.currentFloor = readInt(buf, false);
		this.instanceId = readInt(buf, false);
		this.firstSuccess = readString(buf);
		this.lifeMaxInstanceId = readInt(buf, false);
		this.firstRewardInstanceId = readInt(buf, false);
		this.resetCount = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, currentMonsterWeaken, false);
		this.writeInt(buf, currentFloor, false);
		this.writeInt(buf, instanceId, false);
		this.writeString(buf, firstSuccess);
		this.writeInt(buf, lifeMaxInstanceId, false);
		this.writeInt(buf, firstRewardInstanceId, false);
		this.writeInt(buf, resetCount, false);
		return true;
	}
}
