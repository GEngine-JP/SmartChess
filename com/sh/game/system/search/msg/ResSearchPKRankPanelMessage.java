package com.sh.game.system.search.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.search.msg.bean.SearchRankInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送探索PK排名信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSearchPKRankPanelMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSearchPKRankPanelMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 38011;
	}
	
	/**
	 * 排名信息
	 */
	private List<SearchRankInfo> rankInfo = new ArrayList<>();
	/**
	 * 我的排名
	 */
	private int rank;

	public List<SearchRankInfo> getRankInfo() {
		return rankInfo;
	}

	public void setRankInfo(List<SearchRankInfo> rankInfo) {
		this.rankInfo = rankInfo;
	}
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int rankInfoLength = readShort(buf);
		for (int rankInfoI = 0; rankInfoI < rankInfoLength; rankInfoI++) {
			if (readByte(buf) == 0) { 
				this.rankInfo.add(null);
			} else {
				SearchRankInfo searchRankInfo = new SearchRankInfo();
				searchRankInfo.read(buf);
				this.rankInfo.add(searchRankInfo);
			}
		}		this.rank = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.rankInfo.size());
		for (int rankInfoI = 0; rankInfoI < this.rankInfo.size(); rankInfoI++) {
			this.writeBean(buf, this.rankInfo.get(rankInfoI));
		}		this.writeInt(buf, rank, false);
		return true;
	}
}
