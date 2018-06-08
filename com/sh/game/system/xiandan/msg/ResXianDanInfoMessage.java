package com.sh.game.system.xiandan.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.xiandan.msg.bean.XianDanInfoBean;
import com.sh.game.system.xiandan.msg.bean.HeroXianDanInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送仙丹信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResXianDanInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResXianDanInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 64003;
	}
	
	/**
	 * 角色仙丹信息
	 */
	private List<XianDanInfoBean> roleXianDanList = new ArrayList<>();
	/**
	 * 英雄仙丹信息
	 */
	private List<HeroXianDanInfoBean> heroXianDanList = new ArrayList<>();

	public List<XianDanInfoBean> getRoleXianDanList() {
		return roleXianDanList;
	}

	public void setRoleXianDanList(List<XianDanInfoBean> roleXianDanList) {
		this.roleXianDanList = roleXianDanList;
	}
	public List<HeroXianDanInfoBean> getHeroXianDanList() {
		return heroXianDanList;
	}

	public void setHeroXianDanList(List<HeroXianDanInfoBean> heroXianDanList) {
		this.heroXianDanList = heroXianDanList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int roleXianDanListLength = readShort(buf);
		for (int roleXianDanListI = 0; roleXianDanListI < roleXianDanListLength; roleXianDanListI++) {
			if (readByte(buf) == 0) { 
				this.roleXianDanList.add(null);
			} else {
				XianDanInfoBean xianDanInfoBean = new XianDanInfoBean();
				xianDanInfoBean.read(buf);
				this.roleXianDanList.add(xianDanInfoBean);
			}
		}		int heroXianDanListLength = readShort(buf);
		for (int heroXianDanListI = 0; heroXianDanListI < heroXianDanListLength; heroXianDanListI++) {
			if (readByte(buf) == 0) { 
				this.heroXianDanList.add(null);
			} else {
				HeroXianDanInfoBean heroXianDanInfoBean = new HeroXianDanInfoBean();
				heroXianDanInfoBean.read(buf);
				this.heroXianDanList.add(heroXianDanInfoBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.roleXianDanList.size());
		for (int roleXianDanListI = 0; roleXianDanListI < this.roleXianDanList.size(); roleXianDanListI++) {
			this.writeBean(buf, this.roleXianDanList.get(roleXianDanListI));
		}		writeShort(buf, this.heroXianDanList.size());
		for (int heroXianDanListI = 0; heroXianDanListI < this.heroXianDanList.size(); heroXianDanListI++) {
			this.writeBean(buf, this.heroXianDanList.get(heroXianDanListI));
		}
		return true;
	}
}
