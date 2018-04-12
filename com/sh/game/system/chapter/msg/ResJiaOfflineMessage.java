package com.sh.game.system.chapter.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>最小化奖励的消息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResJiaOfflineMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResJiaOfflineMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 41009;
	}
	
	/**
	 * 离线时间
	 */
	private int offlineTime;

	/**
	 * 金币
	 */
	private int gold;

	/**
	 * 经验
	 */
	private int exp;

	/**
	 * 普通
	 */
	private int normal;

	/**
	 * 紫色
	 */
	private int purple;

	/**
	 * 橙色
	 */
	private int orange;

	/**
	 * 损失的装备
	 */
	private int lost;

	/**
	 * vip获得的经验
	 */
	private int vipExp;

	/**
	 * vip获得的金币
	 */
	private int vipGold;


	public int getOfflineTime() {
		return offlineTime;
	}

	public void setOfflineTime(int offlineTime) {
		this.offlineTime = offlineTime;
	}

	
	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	
	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	
	public int getNormal() {
		return normal;
	}

	public void setNormal(int normal) {
		this.normal = normal;
	}

	
	public int getPurple() {
		return purple;
	}

	public void setPurple(int purple) {
		this.purple = purple;
	}

	
	public int getOrange() {
		return orange;
	}

	public void setOrange(int orange) {
		this.orange = orange;
	}

	
	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	
	public int getVipExp() {
		return vipExp;
	}

	public void setVipExp(int vipExp) {
		this.vipExp = vipExp;
	}

	
	public int getVipGold() {
		return vipGold;
	}

	public void setVipGold(int vipGold) {
		this.vipGold = vipGold;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.offlineTime = readInt(buf, false);
		this.gold = readInt(buf, false);
		this.exp = readInt(buf, false);
		this.normal = readInt(buf, false);
		this.purple = readInt(buf, false);
		this.orange = readInt(buf, false);
		this.lost = readInt(buf, false);
		this.vipExp = readInt(buf, false);
		this.vipGold = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, offlineTime, false);
		this.writeInt(buf, gold, false);
		this.writeInt(buf, exp, false);
		this.writeInt(buf, normal, false);
		this.writeInt(buf, purple, false);
		this.writeInt(buf, orange, false);
		this.writeInt(buf, lost, false);
		this.writeInt(buf, vipExp, false);
		this.writeInt(buf, vipGold, false);

		return true;
	}
}

