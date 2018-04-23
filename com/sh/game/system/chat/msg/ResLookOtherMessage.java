package com.sh.game.system.chat.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.chat.msg.bean.RoleInfoBean;
import com.sh.game.system.chat.msg.bean.HeroInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>查看他人信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLookOtherMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLookOtherMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 6007;
	}
	
	/**
	 * 玩家信息
	 */
	private RoleInfoBean roleInfoBean;
	/**
	 * 英雄信息
	 */
	private List<HeroInfoBean> heroInfoList = new ArrayList<>();

	public RoleInfoBean getRoleInfoBean() {
		return roleInfoBean;
	}

	public void setRoleInfoBean(RoleInfoBean roleInfoBean) {
		this.roleInfoBean = roleInfoBean;
	}

		public List<HeroInfoBean> getHeroInfoList() {
		return heroInfoList;
	}

	public void setHeroInfoList(List<HeroInfoBean> heroInfoList) {
		this.heroInfoList = heroInfoList;
	}

	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			RoleInfoBean roleInfoBean = new RoleInfoBean();
			roleInfoBean.read(buf);
			this.roleInfoBean = roleInfoBean;
		}
		int heroInfoListLength = readShort(buf);
		for (int heroInfoListI = 0; heroInfoListI < heroInfoListLength; heroInfoListI++) {
			if (readByte(buf) == 0) { 
				this.heroInfoList.add(null);
			} else {
				HeroInfoBean heroInfoBean = new HeroInfoBean();
				heroInfoBean.read(buf);
				this.heroInfoList.add(heroInfoBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, roleInfoBean);
		writeShort(buf, this.heroInfoList.size());
		for (int heroInfoListI = 0; heroInfoListI < this.heroInfoList.size(); heroInfoListI++) {
			this.writeBean(buf, this.heroInfoList.get(heroInfoListI));
		}
		return true;
	}
}
