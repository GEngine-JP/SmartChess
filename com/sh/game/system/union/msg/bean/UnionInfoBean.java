package com.sh.game.system.union.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class UnionInfoBean extends KryoBean {

	/**
	 * 帮会id
	 */
	private long unionId;

	/**
	 * 帮会名
	 */
	private String unionName;

	/**
	 * 帮会会长名
	 */
	private String leaderName;

	/**
	 * 帮会公告
	 */
	private String announcement;

	/**
	 * 帮会等级
	 */
	private int unionLevel;

	/**
	 * 帮会人数
	 */
	private int unionNum;

	/**
	 * 帮会申请状态 1可申请 2已申请
	 */
	private int applyState;

	/**
	 * 帮会创建时间
	 */
	private long createTime;

	/**
	 * 帮会战力
	 */
	private int nbValue;

	/**
	 * 帮会资金
	 */
	private int unionGold;

	/**
	 * 1为自动进入
	 */
	private int autoEnter;


	public long getUnionId() {
		return unionId;
	}

	public void setUnionId(long unionId) {
		this.unionId = unionId;
	}

	
	public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}

	
	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	
	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	
	public int getUnionLevel() {
		return unionLevel;
	}

	public void setUnionLevel(int unionLevel) {
		this.unionLevel = unionLevel;
	}

	
	public int getUnionNum() {
		return unionNum;
	}

	public void setUnionNum(int unionNum) {
		this.unionNum = unionNum;
	}

	
	public int getApplyState() {
		return applyState;
	}

	public void setApplyState(int applyState) {
		this.applyState = applyState;
	}

	
	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	
	public int getNbValue() {
		return nbValue;
	}

	public void setNbValue(int nbValue) {
		this.nbValue = nbValue;
	}

	
	public int getUnionGold() {
		return unionGold;
	}

	public void setUnionGold(int unionGold) {
		this.unionGold = unionGold;
	}

	
	public int getAutoEnter() {
		return autoEnter;
	}

	public void setAutoEnter(int autoEnter) {
		this.autoEnter = autoEnter;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.unionId = readLong(buf);
		this.unionName = readString(buf);
		this.leaderName = readString(buf);
		this.announcement = readString(buf);
		this.unionLevel = readInt(buf, false);
		this.unionNum = readInt(buf, false);
		this.applyState = readInt(buf, false);
		this.createTime = readLong(buf);
		this.nbValue = readInt(buf, false);
		this.unionGold = readInt(buf, false);
		this.autoEnter = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, unionId);
		this.writeString(buf, unionName);
		this.writeString(buf, leaderName);
		this.writeString(buf, announcement);
		this.writeInt(buf, unionLevel, false);
		this.writeInt(buf, unionNum, false);
		this.writeInt(buf, applyState, false);
		this.writeLong(buf, createTime);
		this.writeInt(buf, nbValue, false);
		this.writeInt(buf, unionGold, false);
		this.writeInt(buf, autoEnter, false);

		return true;
	}
}

