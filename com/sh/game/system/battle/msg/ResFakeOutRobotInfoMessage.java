package com.sh.game.system.battle.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.battle.msg.bean.TeamInfoBean;

/**
 * <p>返回野外副本假人信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResFakeOutRobotInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResFakeOutRobotInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 60003;
	}
	
	/**
	 * 假人信息
	 */
	private TeamInfoBean teamInfoBean;

	public TeamInfoBean getTeamInfoBean() {
		return teamInfoBean;
	}

	public void setTeamInfoBean(TeamInfoBean teamInfoBean) {
		this.teamInfoBean = teamInfoBean;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			TeamInfoBean teamInfoBean = new TeamInfoBean();
			teamInfoBean.read(buf);
			this.teamInfoBean = teamInfoBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, teamInfoBean);
		return true;
	}
}
