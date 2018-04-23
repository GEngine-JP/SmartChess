package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.union.msg.bean.UnionChallengeRank;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送行会挑战排行信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendUnionChallengetRankMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendUnionChallengetRankMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23033;
	}
	
	/**
	 * 排行信息
	 */
	private List<UnionChallengeRank> rankInfo = new ArrayList<>();
	/**
	 * 本人的排行
	 */
	private int myRank;

	public List<UnionChallengeRank> getRankInfo() {
		return rankInfo;
	}

	public void setRankInfo(List<UnionChallengeRank> rankInfo) {
		this.rankInfo = rankInfo;
	}
	public int getMyRank() {
		return myRank;
	}

	public void setMyRank(int myRank) {
		this.myRank = myRank;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int rankInfoLength = readShort(buf);
		for (int rankInfoI = 0; rankInfoI < rankInfoLength; rankInfoI++) {
			if (readByte(buf) == 0) { 
				this.rankInfo.add(null);
			} else {
				UnionChallengeRank unionChallengeRank = new UnionChallengeRank();
				unionChallengeRank.read(buf);
				this.rankInfo.add(unionChallengeRank);
			}
		}		this.myRank = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.rankInfo.size());
		for (int rankInfoI = 0; rankInfoI < this.rankInfo.size(); rankInfoI++) {
			this.writeBean(buf, this.rankInfo.get(rankInfoI));
		}		this.writeInt(buf, myRank, false);
		return true;
	}
}
