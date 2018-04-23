package com.sh.game.system.search.msg.bean;

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

public class SearchTeamInfoBean extends KryoBean {

	/**
	 * 参战列表
	 */
	private List<SearchTeamMemberBean> teamMemberBean = new ArrayList<>();

	public List<SearchTeamMemberBean> getTeamMemberBean() {
		return teamMemberBean;
	}

	public void setTeamMemberBean(List<SearchTeamMemberBean> teamMemberBean) {
		this.teamMemberBean = teamMemberBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		int teamMemberBeanLength = readShort(buf);
		for (int teamMemberBeanI = 0; teamMemberBeanI < teamMemberBeanLength; teamMemberBeanI++) {
			if (readByte(buf) == 0) { 
				this.teamMemberBean.add(null);
			} else {
				SearchTeamMemberBean searchTeamMemberBean = new SearchTeamMemberBean();
				searchTeamMemberBean.read(buf);
				this.teamMemberBean.add(searchTeamMemberBean);
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
