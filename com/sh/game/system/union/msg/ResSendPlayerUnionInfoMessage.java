package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.union.msg.bean.UnionInfoBean;
import com.sh.game.system.union.msg.bean.PositionInfo;
import com.sh.game.system.union.msg.bean.UnionMemberInfoBean;
import com.sh.game.system.union.msg.bean.UnionSettingBean;
import com.sh.game.system.union.msg.bean.UnionEventBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送玩家所在帮会信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendPlayerUnionInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendPlayerUnionInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23005;
	}
	
	/**
	 * 帮会信息
	 */
	private UnionInfoBean unionInfo;
	/**
	 * 贡献
	 */
	private long contribution;
	/**
	 * 历史贡献
	 */
	private long contributionHistory;
	/**
	 * 帮会职位信息
	 */
	private PositionInfo positionInfo;
	/**
	 * 帮会成员信息
	 */
	private List<UnionMemberInfoBean> memberInfo = new ArrayList<>();
	/**
	 * 帮会设置
	 */
	private List<UnionSettingBean> unionSetting = new ArrayList<>();
	/**
	 * 帮会时间记录
	 */
	private List<UnionEventBean> unionEventBean = new ArrayList<>();

	public UnionInfoBean getUnionInfo() {
		return unionInfo;
	}

	public void setUnionInfo(UnionInfoBean unionInfo) {
		this.unionInfo = unionInfo;
	}

		public long getContribution() {
		return contribution;
	}

	public void setContribution(long contribution) {
		this.contribution = contribution;
	}

		public long getContributionHistory() {
		return contributionHistory;
	}

	public void setContributionHistory(long contributionHistory) {
		this.contributionHistory = contributionHistory;
	}

		public PositionInfo getPositionInfo() {
		return positionInfo;
	}

	public void setPositionInfo(PositionInfo positionInfo) {
		this.positionInfo = positionInfo;
	}

		public List<UnionMemberInfoBean> getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(List<UnionMemberInfoBean> memberInfo) {
		this.memberInfo = memberInfo;
	}
	public List<UnionSettingBean> getUnionSetting() {
		return unionSetting;
	}

	public void setUnionSetting(List<UnionSettingBean> unionSetting) {
		this.unionSetting = unionSetting;
	}
	public List<UnionEventBean> getUnionEventBean() {
		return unionEventBean;
	}

	public void setUnionEventBean(List<UnionEventBean> unionEventBean) {
		this.unionEventBean = unionEventBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			UnionInfoBean unionInfoBean = new UnionInfoBean();
			unionInfoBean.read(buf);
			this.unionInfo = unionInfoBean;
		}
		this.contribution = readLong(buf);
		this.contributionHistory = readLong(buf);
		if (readByte(buf) != 0) {
			PositionInfo positionInfo = new PositionInfo();
			positionInfo.read(buf);
			this.positionInfo = positionInfo;
		}
		int memberInfoLength = readShort(buf);
		for (int memberInfoI = 0; memberInfoI < memberInfoLength; memberInfoI++) {
			if (readByte(buf) == 0) { 
				this.memberInfo.add(null);
			} else {
				UnionMemberInfoBean unionMemberInfoBean = new UnionMemberInfoBean();
				unionMemberInfoBean.read(buf);
				this.memberInfo.add(unionMemberInfoBean);
			}
		}		int unionSettingLength = readShort(buf);
		for (int unionSettingI = 0; unionSettingI < unionSettingLength; unionSettingI++) {
			if (readByte(buf) == 0) { 
				this.unionSetting.add(null);
			} else {
				UnionSettingBean unionSettingBean = new UnionSettingBean();
				unionSettingBean.read(buf);
				this.unionSetting.add(unionSettingBean);
			}
		}		int unionEventBeanLength = readShort(buf);
		for (int unionEventBeanI = 0; unionEventBeanI < unionEventBeanLength; unionEventBeanI++) {
			if (readByte(buf) == 0) { 
				this.unionEventBean.add(null);
			} else {
				UnionEventBean unionEventBean = new UnionEventBean();
				unionEventBean.read(buf);
				this.unionEventBean.add(unionEventBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, unionInfo);
		this.writeLong(buf, contribution);
		this.writeLong(buf, contributionHistory);
		this.writeBean(buf, positionInfo);
		writeShort(buf, this.memberInfo.size());
		for (int memberInfoI = 0; memberInfoI < this.memberInfo.size(); memberInfoI++) {
			this.writeBean(buf, this.memberInfo.get(memberInfoI));
		}		writeShort(buf, this.unionSetting.size());
		for (int unionSettingI = 0; unionSettingI < this.unionSetting.size(); unionSettingI++) {
			this.writeBean(buf, this.unionSetting.get(unionSettingI));
		}		writeShort(buf, this.unionEventBean.size());
		for (int unionEventBeanI = 0; unionEventBeanI < this.unionEventBean.size(); unionEventBeanI++) {
			this.writeBean(buf, this.unionEventBean.get(unionEventBeanI));
		}
		return true;
	}
}
