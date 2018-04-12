package com.sh.game.system.fight.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;

import com.sh.game.system.fight.msg.bean.TeamMemberBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class TeamInfoBean extends KryoBean {

	/**
	 * 参战列表
	 */
	private List<TeamMemberBean> teamMemberBean = new ArrayList<TeamMemberBean>();


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

