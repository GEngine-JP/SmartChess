package com.sh.game.system.fight.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.fight.msg.bean.TeamInfoBean;
import com.sh.game.system.fight.msg.bean.FightDataBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回天梯战斗信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResFightMessage2 extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResFightMessage2() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 25008;
	}
	
	/**
	 * 胜方的唯一id
	 */
	private long result;

	/**
	 * 主动攻击一方的id
	 */
	private long attackId;

	/**
	 * 回合校验
	 */
	private int count;

	/**
	 * 对方队伍信息
	 */
	private TeamInfoBean teamInfoBean;

	/**
	 * 战报
	 */
	private List<FightDataBean> fightDataBean = new ArrayList<FightDataBean>();


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

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
		this.count = readInt(buf, false);
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
		this.writeInt(buf, count, false);
		this.writeBean(buf, teamInfoBean);
		writeShort(buf, this.fightDataBean.size());
		for (int fightDataBeanI = 0; fightDataBeanI < this.fightDataBean.size(); fightDataBeanI++) {
			this.writeBean(buf, this.fightDataBean.get(fightDataBeanI));
		}


		return true;
	}
}

