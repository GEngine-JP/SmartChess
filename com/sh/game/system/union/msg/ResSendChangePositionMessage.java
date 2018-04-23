package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.union.msg.bean.UnionMemberInfoBean;
import com.sh.game.system.union.msg.bean.PositionInfo;

/**
 * <p>发送调整职位信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendChangePositionMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendChangePositionMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23017;
	}
	
	/**
	 * 玩家职位信息
	 */
	private UnionMemberInfoBean changePosition;
	/**
	 * 会长职位信息
	 */
	private UnionMemberInfoBean leaderChange;
	/**
	 * 职位信息
	 */
	private PositionInfo positionInfo;

	public UnionMemberInfoBean getChangePosition() {
		return changePosition;
	}

	public void setChangePosition(UnionMemberInfoBean changePosition) {
		this.changePosition = changePosition;
	}

		public UnionMemberInfoBean getLeaderChange() {
		return leaderChange;
	}

	public void setLeaderChange(UnionMemberInfoBean leaderChange) {
		this.leaderChange = leaderChange;
	}

		public PositionInfo getPositionInfo() {
		return positionInfo;
	}

	public void setPositionInfo(PositionInfo positionInfo) {
		this.positionInfo = positionInfo;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			UnionMemberInfoBean unionMemberInfoBean = new UnionMemberInfoBean();
			unionMemberInfoBean.read(buf);
			this.changePosition = unionMemberInfoBean;
		}
		if (readByte(buf) != 0) {
			UnionMemberInfoBean unionMemberInfoBean = new UnionMemberInfoBean();
			unionMemberInfoBean.read(buf);
			this.leaderChange = unionMemberInfoBean;
		}
		if (readByte(buf) != 0) {
			PositionInfo positionInfo = new PositionInfo();
			positionInfo.read(buf);
			this.positionInfo = positionInfo;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, changePosition);
		this.writeBean(buf, leaderChange);
		this.writeBean(buf, positionInfo);
		return true;
	}
}
