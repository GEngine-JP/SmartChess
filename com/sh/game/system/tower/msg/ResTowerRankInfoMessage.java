package com.sh.game.system.tower.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.tower.msg.bean.TowerRankBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送通天塔排行信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResTowerRankInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResTowerRankInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 54003;
	}
	
	/**
	 * 我的排名
	 */
	private int rank;
	/**
	 * 排行信息
	 */
	private List<TowerRankBean> rankInfos = new ArrayList<>();

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

		public List<TowerRankBean> getRankInfos() {
		return rankInfos;
	}

	public void setRankInfos(List<TowerRankBean> rankInfos) {
		this.rankInfos = rankInfos;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.rank = readInt(buf, false);
		int rankInfosLength = readShort(buf);
		for (int rankInfosI = 0; rankInfosI < rankInfosLength; rankInfosI++) {
			if (readByte(buf) == 0) { 
				this.rankInfos.add(null);
			} else {
				TowerRankBean towerRankBean = new TowerRankBean();
				towerRankBean.read(buf);
				this.rankInfos.add(towerRankBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, rank, false);
		writeShort(buf, this.rankInfos.size());
		for (int rankInfosI = 0; rankInfosI < this.rankInfos.size(); rankInfosI++) {
			this.writeBean(buf, this.rankInfos.get(rankInfosI));
		}
		return true;
	}
}
