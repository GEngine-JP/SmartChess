package com.sh.game.system.fight.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class RoleTeamInfoBean extends KryoBean {

	/**
	 * 视野信息
	 */
	private TeamInfoBean teamInfoBean;
	/**
	 * 变化玩家id
	 */
	private long uid;

	public TeamInfoBean getTeamInfoBean() {
		return teamInfoBean;
	}

	public void setTeamInfoBean(TeamInfoBean teamInfoBean) {
		this.teamInfoBean = teamInfoBean;
	}

		public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			TeamInfoBean teamInfoBean = new TeamInfoBean();
			teamInfoBean.read(buf);
			this.teamInfoBean = teamInfoBean;
		}
		this.uid = readLong(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, teamInfoBean);
		this.writeLong(buf, uid);
		return true;
	}
}
