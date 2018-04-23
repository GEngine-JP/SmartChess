package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.role.msg.bean.SpecialRingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送特戒信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendSpecialRingInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendSpecialRingInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8018;
	}
	
	/**
	 * 特戒信息
	 */
	private List<SpecialRingBean> infos = new ArrayList<>();
	/**
	 * 特戒战斗力
	 */
	private int fightValue;

	public List<SpecialRingBean> getInfos() {
		return infos;
	}

	public void setInfos(List<SpecialRingBean> infos) {
		this.infos = infos;
	}
	public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int infosLength = readShort(buf);
		for (int infosI = 0; infosI < infosLength; infosI++) {
			if (readByte(buf) == 0) { 
				this.infos.add(null);
			} else {
				SpecialRingBean specialRingBean = new SpecialRingBean();
				specialRingBean.read(buf);
				this.infos.add(specialRingBean);
			}
		}		this.fightValue = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.infos.size());
		for (int infosI = 0; infosI < this.infos.size(); infosI++) {
			this.writeBean(buf, this.infos.get(infosI));
		}		this.writeInt(buf, fightValue, false);
		return true;
	}
}
