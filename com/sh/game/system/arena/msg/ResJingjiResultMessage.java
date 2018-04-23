package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.arena.msg.bean.RankRewardBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回竞技结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResJingjiResultMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResJingjiResultMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37006;
	}
	
	/**
	 * 结果 1赢了且最高名次和当前名次都提高 2赢了且当前名次提高 3赢了且名次未提高 4输了
	 */
	private int result;
	/**
	 * 现在名次
	 */
	private int nowRank;
	/**
	 * 原来名次
	 */
	private int oldRank;
	/**
	 * 挑战对象的名字
	 */
	private String targetName;
	/**
	 * 战斗结果奖励
	 */
	private List<RankRewardBean> resultRewardList = new ArrayList<>();
	/**
	 * 名次提升奖励
	 */
	private List<RankRewardBean> rankRewardList = new ArrayList<>();

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

		public int getNowRank() {
		return nowRank;
	}

	public void setNowRank(int nowRank) {
		this.nowRank = nowRank;
	}

		public int getOldRank() {
		return oldRank;
	}

	public void setOldRank(int oldRank) {
		this.oldRank = oldRank;
	}

		public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

		public List<RankRewardBean> getResultRewardList() {
		return resultRewardList;
	}

	public void setResultRewardList(List<RankRewardBean> resultRewardList) {
		this.resultRewardList = resultRewardList;
	}
	public List<RankRewardBean> getRankRewardList() {
		return rankRewardList;
	}

	public void setRankRewardList(List<RankRewardBean> rankRewardList) {
		this.rankRewardList = rankRewardList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.result = readInt(buf, false);
		this.nowRank = readInt(buf, false);
		this.oldRank = readInt(buf, false);
		this.targetName = readString(buf);
		int resultRewardListLength = readShort(buf);
		for (int resultRewardListI = 0; resultRewardListI < resultRewardListLength; resultRewardListI++) {
			if (readByte(buf) == 0) { 
				this.resultRewardList.add(null);
			} else {
				RankRewardBean rankRewardBean = new RankRewardBean();
				rankRewardBean.read(buf);
				this.resultRewardList.add(rankRewardBean);
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

		this.writeInt(buf, result, false);
		this.writeInt(buf, nowRank, false);
		this.writeInt(buf, oldRank, false);
		this.writeString(buf, targetName);
		writeShort(buf, this.resultRewardList.size());
		for (int resultRewardListI = 0; resultRewardListI < this.resultRewardList.size(); resultRewardListI++) {
			this.writeBean(buf, this.resultRewardList.get(resultRewardListI));
		}		writeShort(buf, this.rankRewardList.size());
		for (int rankRewardListI = 0; rankRewardListI < this.rankRewardList.size(); rankRewardListI++) {
			this.writeBean(buf, this.rankRewardList.get(rankRewardListI));
		}
		return true;
	}
}
