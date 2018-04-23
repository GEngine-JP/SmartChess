package com.sh.game.system.recharge.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.recharge.msg.bean.DayPayInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送每日充值信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDayRechargeInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDayRechargeInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 39006;
	}
	
	/**
	 * 每日充值信息
	 */
	private List<DayPayInfo> infos = new ArrayList<>();
	/**
	 * 当日充值总数
	 */
	private int dayTotalRecharge;

	public List<DayPayInfo> getInfos() {
		return infos;
	}

	public void setInfos(List<DayPayInfo> infos) {
		this.infos = infos;
	}
	public int getDayTotalRecharge() {
		return dayTotalRecharge;
	}

	public void setDayTotalRecharge(int dayTotalRecharge) {
		this.dayTotalRecharge = dayTotalRecharge;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int infosLength = readShort(buf);
		for (int infosI = 0; infosI < infosLength; infosI++) {
			if (readByte(buf) == 0) { 
				this.infos.add(null);
			} else {
				DayPayInfo dayPayInfo = new DayPayInfo();
				dayPayInfo.read(buf);
				this.infos.add(dayPayInfo);
			}
		}		this.dayTotalRecharge = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.infos.size());
		for (int infosI = 0; infosI < this.infos.size(); infosI++) {
			this.writeBean(buf, this.infos.get(infosI));
		}		this.writeInt(buf, dayTotalRecharge, false);
		return true;
	}
}
