package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.ladder.msg.bean.RewardBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回天梯战斗结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLadderResultMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLadderResultMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5014;
	}
	
	/**
	 * 成功失败
	 */
	private boolean result;
	/**
	 * 上次段位
	 */
	private int lastRank;
	/**
	 * 段位
	 */
	private int rank;
	/**
	 * 上次星星
	 */
	private int star;
	/**
	 * 星星
	 */
	private int lastStar;
	/**
	 * 上次积分
	 */
	private int point;
	/**
	 * 积分
	 */
	private int lastPoint;
	/**
	 * 奖励
	 */
	private List<RewardBean> rewardBeanList = new ArrayList<>();

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

		public int getLastRank() {
		return lastRank;
	}

	public void setLastRank(int lastRank) {
		this.lastRank = lastRank;
	}

		public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

		public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

		public int getLastStar() {
		return lastStar;
	}

	public void setLastStar(int lastStar) {
		this.lastStar = lastStar;
	}

		public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

		public int getLastPoint() {
		return lastPoint;
	}

	public void setLastPoint(int lastPoint) {
		this.lastPoint = lastPoint;
	}

		public List<RewardBean> getRewardBeanList() {
		return rewardBeanList;
	}

	public void setRewardBeanList(List<RewardBean> rewardBeanList) {
		this.rewardBeanList = rewardBeanList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.result = readBoolean(buf);
		this.lastRank = readInt(buf, false);
		this.rank = readInt(buf, false);
		this.star = readInt(buf, false);
		this.lastStar = readInt(buf, false);
		this.point = readInt(buf, false);
		this.lastPoint = readInt(buf, false);
		int rewardBeanListLength = readShort(buf);
		for (int rewardBeanListI = 0; rewardBeanListI < rewardBeanListLength; rewardBeanListI++) {
			if (readByte(buf) == 0) { 
				this.rewardBeanList.add(null);
			} else {
				RewardBean rewardBean = new RewardBean();
				rewardBean.read(buf);
				this.rewardBeanList.add(rewardBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBoolean(buf, result);
		this.writeInt(buf, lastRank, false);
		this.writeInt(buf, rank, false);
		this.writeInt(buf, star, false);
		this.writeInt(buf, lastStar, false);
		this.writeInt(buf, point, false);
		this.writeInt(buf, lastPoint, false);
		writeShort(buf, this.rewardBeanList.size());
		for (int rewardBeanListI = 0; rewardBeanListI < this.rewardBeanList.size(); rewardBeanListI++) {
			this.writeBean(buf, this.rewardBeanList.get(rewardBeanListI));
		}
		return true;
	}
}
