package com.sh.game.system.ring.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.ring.msg.bean.SpecialRingInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送特戒信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendSpecialRingInfosMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendSpecialRingInfosMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 53001;
	}
	
	/**
	 * 角色特戒
	 */
	private List<SpecialRingInfo> roleRings = new ArrayList<>();
	/**
	 * 英雄特戒
	 */
	private List<SpecialRingInfo> heroRings = new ArrayList<>();

	public List<SpecialRingInfo> getRoleRings() {
		return roleRings;
	}

	public void setRoleRings(List<SpecialRingInfo> roleRings) {
		this.roleRings = roleRings;
	}
	public List<SpecialRingInfo> getHeroRings() {
		return heroRings;
	}

	public void setHeroRings(List<SpecialRingInfo> heroRings) {
		this.heroRings = heroRings;
	}

	@Override
	public boolean read(KryoInput buf) {

		int roleRingsLength = readShort(buf);
		for (int roleRingsI = 0; roleRingsI < roleRingsLength; roleRingsI++) {
			if (readByte(buf) == 0) { 
				this.roleRings.add(null);
			} else {
				SpecialRingInfo specialRingInfo = new SpecialRingInfo();
				specialRingInfo.read(buf);
				this.roleRings.add(specialRingInfo);
			}
		}		int heroRingsLength = readShort(buf);
		for (int heroRingsI = 0; heroRingsI < heroRingsLength; heroRingsI++) {
			if (readByte(buf) == 0) { 
				this.heroRings.add(null);
			} else {
				SpecialRingInfo specialRingInfo = new SpecialRingInfo();
				specialRingInfo.read(buf);
				this.heroRings.add(specialRingInfo);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.roleRings.size());
		for (int roleRingsI = 0; roleRingsI < this.roleRings.size(); roleRingsI++) {
			this.writeBean(buf, this.roleRings.get(roleRingsI));
		}		writeShort(buf, this.heroRings.size());
		for (int heroRingsI = 0; heroRingsI < this.heroRings.size(); heroRingsI++) {
			this.writeBean(buf, this.heroRings.get(heroRingsI));
		}
		return true;
	}
}
