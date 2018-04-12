package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.role.msg.bean.SpecialRingBean;


/**
 * <p>发送特戒变化信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendSpecialRingChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendSpecialRingChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8019;
	}
	
	/**
	 * 特戒信息
	 */
	private SpecialRingBean info;

	/**
	 * 特戒战斗力
	 */
	private int fightValue;


	public SpecialRingBean getInfo() {
		return info;
	}

	public void setInfo(SpecialRingBean info) {
		this.info = info;
	}

	
	public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		if (readByte(buf) != 0) {
			SpecialRingBean specialRingBean = new SpecialRingBean();
			specialRingBean.read(buf);
			this.info = specialRingBean;
		}
		this.fightValue = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeBean(buf, info);
		this.writeInt(buf, fightValue, false);

		return true;
	}
}

