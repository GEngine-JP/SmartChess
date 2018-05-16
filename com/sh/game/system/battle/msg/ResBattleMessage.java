package com.sh.game.system.battle.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.battle.msg.bean.TeamInfoBean;
import com.sh.game.system.battle.msg.bean.BattleDataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回战斗信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResBattleMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResBattleMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 60002;
	}
	
	/**
	 * 胜方队伍的id
	 */
	private long result;
	/**
	 * 主动攻击一方的id
	 */
	private long attackId;
	/**
	 * 自己的队伍信息
	 */
	private TeamInfoBean selfTeamBean;
	/**
	 * 对方队伍信息
	 */
	private TeamInfoBean teamInfoBean;
	/**
	 * 战报
	 */
	private List<BattleDataBean> battleDataBean = new ArrayList<>();

	public long getResult() {
		return result;
	}

	public void setResult(long result) {
		this.result = result;
	}

		public long getAttackId() {
		return attackId;
	}

	public void setAttackId(long attackId) {
		this.attackId = attackId;
	}

		public TeamInfoBean getSelfTeamBean() {
		return selfTeamBean;
	}

	public void setSelfTeamBean(TeamInfoBean selfTeamBean) {
		this.selfTeamBean = selfTeamBean;
	}

		public TeamInfoBean getTeamInfoBean() {
		return teamInfoBean;
	}

	public void setTeamInfoBean(TeamInfoBean teamInfoBean) {
		this.teamInfoBean = teamInfoBean;
	}

		public List<BattleDataBean> getBattleDataBean() {
		return battleDataBean;
	}

	public void setBattleDataBean(List<BattleDataBean> battleDataBean) {
		this.battleDataBean = battleDataBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.result = readLong(buf);
		this.attackId = readLong(buf);
		if (readByte(buf) != 0) {
			TeamInfoBean teamInfoBean = new TeamInfoBean();
			teamInfoBean.read(buf);
			this.selfTeamBean = teamInfoBean;
		}
		if (readByte(buf) != 0) {
			TeamInfoBean teamInfoBean = new TeamInfoBean();
			teamInfoBean.read(buf);
			this.teamInfoBean = teamInfoBean;
		}
		int battleDataBeanLength = readShort(buf);
		for (int battleDataBeanI = 0; battleDataBeanI < battleDataBeanLength; battleDataBeanI++) {
			if (readByte(buf) == 0) { 
				this.battleDataBean.add(null);
			} else {
				BattleDataBean battleDataBean = new BattleDataBean();
				battleDataBean.read(buf);
				this.battleDataBean.add(battleDataBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, result);
		this.writeLong(buf, attackId);
		this.writeBean(buf, selfTeamBean);
		this.writeBean(buf, teamInfoBean);
		writeShort(buf, this.battleDataBean.size());
		for (int battleDataBeanI = 0; battleDataBeanI < this.battleDataBean.size(); battleDataBeanI++) {
			this.writeBean(buf, this.battleDataBean.get(battleDataBeanI));
		}
		return true;
	}
}
