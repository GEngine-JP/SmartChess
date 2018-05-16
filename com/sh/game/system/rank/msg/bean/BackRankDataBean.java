package com.sh.game.system.rank.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class BackRankDataBean extends KryoBean {

	/**
	 * 排行榜数据
	 */
	private RankDataBean rankData;
	/**
	 * 帮会名字
	 */
	private String unionName;

	public RankDataBean getRankData() {
		return rankData;
	}

	public void setRankData(RankDataBean rankData) {
		this.rankData = rankData;
	}

		public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			RankDataBean rankDataBean = new RankDataBean();
			rankDataBean.read(buf);
			this.rankData = rankDataBean;
		}
		this.unionName = readString(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, rankData);
		this.writeString(buf, unionName);
		return true;
	}
}
