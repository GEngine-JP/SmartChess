package com.sh.game.system.battle.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.battle.msg.bean.TeamInfoBean;
import FightDataBean;

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
	 * 对方队伍信息
	 */
	private TeamInfoBean teamInfoBean;
	/**
	 * 战报
	 */
	private List<FightDataBean> fightDataBean = new ArrayList<>();

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

		public TeamInfoBean getTeamInfoBean() {
		return teamInfoBean;
	}

	public void setTeamInfoBean(TeamInfoBean teamInfoBean) {
		this.teamInfoBean = teamInfoBean;
	}

		public List<FightDataBean> getFightDataBean() {
		return fightDataBean;
	}

	public void setFightDataBean(List<FightDataBean> fightDataBean) {
		this.fightDataBean = fightDataBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.result = readLong(buf);
		this.attackId = readLong(buf);
		if (readByte(buf) != 0) {
			TeamInfoBean teamInfoBean = new TeamInfoBean();
			teamInfoBean.read(buf);
			this.teamInfoBean = teamInfoBean;
		}
		int fightDataBeanLength = readShort(buf);
		for (int fightDataBeanI = 0; fightDataBeanI < fightDataBeanLength; fightDataBeanI++) {
			if (readByte(buf) == 0) { 
				this.fightDataBean.add(null);
			} else {
				FightDataBean fightDataBean = new FightDataBean();
				fightDataBean.read(buf);
				this.fightDataBean.add(fightDataBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, result);
		this.writeLong(buf, attackId);
		this.writeBean(buf, teamInfoBean);
		writeShort(buf, this.fightDataBean.size());
		for (int fightDataBeanI = 0; fightDataBeanI < this.fightDataBean.size(); fightDataBeanI++) {
			this.writeBean(buf, this.fightDataBean.get(fightDataBeanI));
		}
		return true;
	}
}
