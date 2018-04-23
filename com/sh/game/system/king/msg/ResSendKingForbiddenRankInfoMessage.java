package com.sh.game.system.king.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.king.msg.bean.KingRankBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送王者禁地排行信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendKingForbiddenRankInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendKingForbiddenRankInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 45003;
	}
	
	/**
	 * 我的排名
	 */
	private int rank;
	/**
	 * 排行信息
	 */
	private List<KingRankBean> rankInfos = new ArrayList<>();

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

		public List<KingRankBean> getRankInfos() {
		return rankInfos;
	}

	public void setRankInfos(List<KingRankBean> rankInfos) {
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
				KingRankBean kingRankBean = new KingRankBean();
				kingRankBean.read(buf);
				this.rankInfos.add(kingRankBean);
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
