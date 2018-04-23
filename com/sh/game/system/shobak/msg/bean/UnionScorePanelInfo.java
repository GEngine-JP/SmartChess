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

public class UnionScorePanelInfo extends KryoBean {

	/**
	 * 名次
	 */
	private int rank;
	/**
	 * 行会名
	 */
	private String unionName;
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
		this.score = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, rank, false);
		this.writeString(buf, unionName);
		this.writeInt(buf, score, false);
		return true;
	}
}
