package com.sh.game.system.king.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送王者禁地面板信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendKingForbiddenPanelInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendKingForbiddenPanelInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 45001;
	}
	
	/**
	 * 角色当前层数
	 */
	private int floor;
	/**
	 * 角色本周最高层数
	 */
	private int maxFloor;
	/**
	 * 角色上周最高层数
	 */
	private int lastMaxFloor;
	/**
	 * 假人id 有怪物发0 没有怪物有假人发id
	 */
	private int robotId;
	/**
	 * 是否可领取每周奖励0不可领取1可领取
	 */
	private int canReward;
	/**
	 * 是否已领取奖励0不可领取1可领取
	 */
	private int state;
	/**
	 * 剩余属性领取次数
	 */
	private int remainNum;
	/**
	 * 最后一关假人id 有怪物发0 没有怪物有假人发id 通过最后一关才发
	 */
	private int lastRobotId;

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

		public int getMaxFloor() {
		return maxFloor;
	}

	public void setMaxFloor(int maxFloor) {
		this.maxFloor = maxFloor;
	}

		public int getLastMaxFloor() {
		return lastMaxFloor;
	}

	public void setLastMaxFloor(int lastMaxFloor) {
		this.lastMaxFloor = lastMaxFloor;
	}

		public int getRobotId() {
		return robotId;
	}

	public void setRobotId(int robotId) {
		this.robotId = robotId;
	}

		public int getCanReward() {
		return canReward;
	}

	public void setCanReward(int canReward) {
		this.canReward = canReward;
	}

		public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

		public int getRemainNum() {
		return remainNum;
	}

	public void setRemainNum(int remainNum) {
		this.remainNum = remainNum;
	}

		public int getLastRobotId() {
		return lastRobotId;
	}

	public void setLastRobotId(int lastRobotId) {
		this.lastRobotId = lastRobotId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.floor = readInt(buf, false);
		this.maxFloor = readInt(buf, false);
		this.lastMaxFloor = readInt(buf, false);
		this.robotId = readInt(buf, false);
		this.canReward = readInt(buf, false);
		this.state = readInt(buf, false);
		this.remainNum = readInt(buf, false);
		this.lastRobotId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, floor, false);
		this.writeInt(buf, maxFloor, false);
		this.writeInt(buf, lastMaxFloor, false);
		this.writeInt(buf, robotId, false);
		this.writeInt(buf, canReward, false);
		this.writeInt(buf, state, false);
		this.writeInt(buf, remainNum, false);
		this.writeInt(buf, lastRobotId, false);
		return true;
	}
}
