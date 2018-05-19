package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>领取过的段位奖励的列表</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLadderRewardListMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLadderRewardListMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5011;
	}
	
	/**
	 * 历史最大
	 */
	private int historyMax;
	/**
	 * 已领过的列表
	 */
	private List<Integer> ladderRewardList = new ArrayList<>();

	public int getHistoryMax() {
		return historyMax;
	}

	public void setHistoryMax(int historyMax) {
		this.historyMax = historyMax;
	}

		public List<Integer> getLadderRewardList() {
		return ladderRewardList;
	}

	public void setLadderRewardList(List<Integer> ladderRewardList) {
		this.ladderRewardList = ladderRewardList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.historyMax = readInt(buf, false);
		int ladderRewardListLength = readShort(buf);
		for (int ladderRewardListI = 0; ladderRewardListI < ladderRewardListLength; ladderRewardListI++) {
			this.ladderRewardList.add(this.readInt(buf, false));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, historyMax, false);
		writeShort(buf, this.ladderRewardList.size());
		for (int ladderRewardListI = 0; ladderRewardListI < this.ladderRewardList.size(); ladderRewardListI++) {
			this.writeInt(buf, this.ladderRewardList.get(ladderRewardListI), false);
		}
		return true;
	}
}
