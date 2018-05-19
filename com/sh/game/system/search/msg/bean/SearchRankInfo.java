package com.sh.game.system.search.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class SearchRankInfo extends KryoBean {

	/**
	 * 排名
	 */
	private int rank;
	/**
	 * 玩家名
	 */
	private String name;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.rank = readInt(buf, false);
		this.name = readString(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, rank, false);
		this.writeString(buf, name);
		return true;
	}
}
