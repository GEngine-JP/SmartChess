package com.sh.game.system.shobak.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class LastSiegeRankInfo extends KryoBean {

	/**
	 * 名次
	 */
	private int rank;
	/**
	 * 行会名
	 */
	private String unionName;
	/**
	 * 会长名
	 */
	private String leaderName;
	/**
	 * 个人名
	 */
	private String personalName;
	/**
	 * 积分
	 */
	private int score;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
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

		public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

		public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.rank = readInt(buf, false);
		this.unionName = readString(buf);
		this.leaderName = readString(buf);
		this.personalName = readString(buf);
		this.score = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, rank, false);
		this.writeString(buf, unionName);
		this.writeString(buf, leaderName);
		this.writeString(buf, personalName);
		this.writeInt(buf, score, false);
		return true;
	}
}
