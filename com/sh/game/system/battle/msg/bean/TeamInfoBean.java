package com.sh.game.system.battle.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class TeamInfoBean extends KryoBean {

	/**
	 * 参战列表
	 */
	private List<TeamMemberBean> teamMemberBean = new ArrayList<>();

	public List<TeamMemberBean> getTeamMemberBean() {
		return teamMemberBean;
	}

	public void setTeamMemberBean(List<TeamMemberBean> teamMemberBean) {
		this.teamMemberBean = teamMemberBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		int teamMemberBeanLength = readShort(buf);
		for (int teamMemberBeanI = 0; teamMemberBeanI < teamMemberBeanLength; teamMemberBeanI++) {
			if (readByte(buf) == 0) { 
				this.teamMemberBean.add(null);
			} else {
				TeamMemberBean teamMemberBean = new TeamMemberBean();
				teamMemberBean.read(buf);
				this.teamMemberBean.add(teamMemberBean);
			}
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.teamMemberBean.size());
		for (int teamMemberBeanI = 0; teamMemberBeanI < this.teamMemberBean.size(); teamMemberBeanI++) {
			this.writeBean(buf, this.teamMemberBean.get(teamMemberBeanI));
		}
		return true;
	}
}
