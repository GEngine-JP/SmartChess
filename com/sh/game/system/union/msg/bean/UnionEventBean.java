package com.sh.game.system.union.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class UnionEventBean extends KryoBean {

	/**
	 * 记录时间
	 */
	private int recordTime;

	/**
	 * 日志id
	 */
	private int announceId;

	/**
	 * 操作者
	 */
	private String operate;

	/**
	 * 目标
	 */
	private String target;

	/**
	 * 行会老的等级
	 */
	private int oldLevel;

	/**
	 * 行会新的等级
	 */
	private int newLevel;

	/**
	 * 发的红包数量
	 */
	private int redPackCount;

	/**
	 * 老的职位
	 */
	private String oldPosition;

	/**
	 * 新的职位
	 */
	private String newPosition;


	public int getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(int recordTime) {
		this.recordTime = recordTime;
	}

	
	public int getAnnounceId() {
		return announceId;
	}

	public void setAnnounceId(int announceId) {
		this.announceId = announceId;
	}

	
	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	
	public int getOldLevel() {
		return oldLevel;
	}

	public void setOldLevel(int oldLevel) {
		this.oldLevel = oldLevel;
	}

	
	public int getNewLevel() {
		return newLevel;
	}

	public void setNewLevel(int newLevel) {
		this.newLevel = newLevel;
	}

	
	public int getRedPackCount() {
		return redPackCount;
	}

	public void setRedPackCount(int redPackCount) {
		this.redPackCount = redPackCount;
	}

	
	public String getOldPosition() {
		return oldPosition;
	}

	public void setOldPosition(String oldPosition) {
		this.oldPosition = oldPosition;
	}

	
	public String getNewPosition() {
		return newPosition;
	}

	public void setNewPosition(String newPosition) {
		this.newPosition = newPosition;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.recordTime = readInt(buf, false);
		this.announceId = readInt(buf, false);
		this.operate = readString(buf);
		this.target = readString(buf);
		this.oldLevel = readInt(buf, false);
		this.newLevel = readInt(buf, false);
		this.redPackCount = readInt(buf, false);
		this.oldPosition = readString(buf);
		this.newPosition = readString(buf);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, recordTime, false);
		this.writeInt(buf, announceId, false);
		this.writeString(buf, operate);
		this.writeString(buf, target);
		this.writeInt(buf, oldLevel, false);
		this.writeInt(buf, newLevel, false);
		this.writeInt(buf, redPackCount, false);
		this.writeString(buf, oldPosition);
		this.writeString(buf, newPosition);

		return true;
	}
}

