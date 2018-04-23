package com.sh.game.system.runes.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.runes.msg.bean.RunesPositionBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>符文数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRunesPositionInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRunesPositionInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 24007;
	}
	
	/**
	 * 战斗力
	 */
	private int fightPower;
	/**
	 * 符文数据
	 */
	private List<RunesPositionBean> runePositionList = new ArrayList<>();

	public int getFightPower() {
		return fightPower;
	}

	public void setFightPower(int fightPower) {
		this.fightPower = fightPower;
	}

		public List<RunesPositionBean> getRunePositionList() {
		return runePositionList;
	}

	public void setRunePositionList(List<RunesPositionBean> runePositionList) {
		this.runePositionList = runePositionList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.fightPower = readInt(buf, false);
		int runePositionListLength = readShort(buf);
		for (int runePositionListI = 0; runePositionListI < runePositionListLength; runePositionListI++) {
			if (readByte(buf) == 0) { 
				this.runePositionList.add(null);
			} else {
				RunesPositionBean runesPositionBean = new RunesPositionBean();
				runesPositionBean.read(buf);
				this.runePositionList.add(runesPositionBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, fightPower, false);
		writeShort(buf, this.runePositionList.size());
		for (int runePositionListI = 0; runePositionListI < this.runePositionList.size(); runePositionListI++) {
			this.writeBean(buf, this.runePositionList.get(runePositionListI));
		}
		return true;
	}
}
