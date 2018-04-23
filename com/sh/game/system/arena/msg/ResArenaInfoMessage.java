package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.arena.msg.bean.ArenaDataBean;
import com.sh.game.system.arena.msg.bean.RankRewardBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>竞技场信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResArenaInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResArenaInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37002;
	}
	
	/**
	 * 当前排名
	 */
	private int nowRank;
	/**
	 * 竞技场数据
	 */
	private List<ArenaDataBean> arenaDataList = new ArrayList<>();
	/**
	 * 奖励数据
	 */
	private List<RankRewardBean> rankRewardList = new ArrayList<>();

	public int getNowRank() {
		return nowRank;
	}

	public void setNowRank(int nowRank) {
		this.nowRank = nowRank;
	}

		public List<ArenaDataBean> getArenaDataList() {
		return arenaDataList;
	}

	public void setArenaDataList(List<ArenaDataBean> arenaDataList) {
		this.arenaDataList = arenaDataList;
	}
	public List<RankRewardBean> getRankRewardList() {
		return rankRewardList;
	}

	public void setRankRewardList(List<RankRewardBean> rankRewardList) {
		this.rankRewardList = rankRewardList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.nowRank = readInt(buf, false);
		int arenaDataListLength = readShort(buf);
		for (int arenaDataListI = 0; arenaDataListI < arenaDataListLength; arenaDataListI++) {
			if (readByte(buf) == 0) { 
				this.arenaDataList.add(null);
			} else {
				ArenaDataBean arenaDataBean = new ArenaDataBean();
				arenaDataBean.read(buf);
				this.arenaDataList.add(arenaDataBean);
			}
		}		int rankRewardListLength = readShort(buf);
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

		this.writeInt(buf, nowRank, false);
		writeShort(buf, this.arenaDataList.size());
		for (int arenaDataListI = 0; arenaDataListI < this.arenaDataList.size(); arenaDataListI++) {
			this.writeBean(buf, this.arenaDataList.get(arenaDataListI));
		}		writeShort(buf, this.rankRewardList.size());
		for (int rankRewardListI = 0; rankRewardListI < this.rankRewardList.size(); rankRewardListI++) {
			this.writeBean(buf, this.rankRewardList.get(rankRewardListI));
		}
		return true;
	}
}
