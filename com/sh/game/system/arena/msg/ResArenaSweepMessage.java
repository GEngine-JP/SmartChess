package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.arena.msg.bean.RankRewardBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>竞技场扫荡返回</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResArenaSweepMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResArenaSweepMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37012;
	}
	
	/**
	 * 战斗结果奖励
	 */
	private List<RankRewardBean> resultRewardList = new ArrayList<RankRewardBean>();


	public List<RankRewardBean> getResultRewardList() {
		return resultRewardList;
	}

	public void setResultRewardList(List<RankRewardBean> resultRewardList) {
		this.resultRewardList = resultRewardList;
	}


	@Override
	public boolean read(KryoInput buf) {
		int resultRewardListLength = readShort(buf);
		for (int resultRewardListI = 0; resultRewardListI < resultRewardListLength; resultRewardListI++) {
			if (readByte(buf) == 0) { 
				this.resultRewardList.add(null);
			} else {
				RankRewardBean rankRewardBean = new RankRewardBean();
				rankRewardBean.read(buf);
				this.resultRewardList.add(rankRewardBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.resultRewardList.size());
		for (int resultRewardListI = 0; resultRewardListI < this.resultRewardList.size(); resultRewardListI++) {
			this.writeBean(buf, this.resultRewardList.get(resultRewardListI));
		}


		return true;
	}
}

