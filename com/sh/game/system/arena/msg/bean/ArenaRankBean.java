package com.sh.game.system.arena.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ArenaRankBean extends KryoBean {

	/**
	 * 开始名次
	 */
	private int startRank;
	/**
	 * 结束名次
	 */
	private int endRank;
	/**
	 * 玩家名字
	 */
	private String name;
	/**
	 * 战力
	 */
	private int fightPower;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * 职业
	 */
	private int career;
	/**
	 * 转生
	 */
	private int rein;
	/**
	 * 等级
	 */
	private int level;
	/**
	 * 奖励数据
	 */
	private List<RankRewardBean> rankRewardList = new ArrayList<>();

	public int getStartRank() {
		return startRank;
	}

	public void setStartRank(int startRank) {
		this.startRank = startRank;
	}

		public int getEndRank() {
		return endRank;
	}

	public void setEndRank(int endRank) {
		this.endRank = endRank;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		public int getFightPower() {
		return fightPower;
	}

	public void setFightPower(int fightPower) {
		this.fightPower = fightPower;
	}

		public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

		public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

		public int getRein() {
		return rein;
	}

	public void setRein(int rein) {
		this.rein = rein;
	}

		public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

		public List<RankRewardBean> getRankRewardList() {
		return rankRewardList;
	}

	public void setRankRewardList(List<RankRewardBean> rankRewardList) {
		this.rankRewardList = rankRewardList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.startRank = readInt(buf, false);
		this.endRank = readInt(buf, false);
		this.name = readString(buf);
		this.fightPower = readInt(buf, false);
		this.sex = readInt(buf, false);
		this.career = readInt(buf, false);
		this.rein = readInt(buf, false);
		this.level = readInt(buf, false);
		int rankRewardListLength = readShort(buf);
		for (int rankRewardListI = 0; rankRewardListI < rankRewardListLength; rankRewardListI++) {
			if (readByte(buf) == 0) { 
				this.rankRewardList.add(null);
			} else {
				RankRewardBean rankRewardBean = new RankRewardBean();
				rankRewardBean.read(buf);
				this.rankRewardList.add(rankRewardBean);
			}
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, startRank, false);
		this.writeInt(buf, endRank, false);
		this.writeString(buf, name);
		this.writeInt(buf, fightPower, false);
		this.writeInt(buf, sex, false);
		this.writeInt(buf, career, false);
		this.writeInt(buf, rein, false);
		this.writeInt(buf, level, false);
		writeShort(buf, this.rankRewardList.size());
		for (int rankRewardListI = 0; rankRewardListI < this.rankRewardList.size(); rankRewardListI++) {
			this.writeBean(buf, this.rankRewardList.get(rankRewardListI));
		}
		return true;
	}
}
