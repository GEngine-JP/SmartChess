package com.sh.game.system.runes.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.runes.msg.bean.RunesBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>符文更新消息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResRunesChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRunesChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 24003;
	}
	
	/**
	 * 符文列表
	 */
	private List<RunesBean> runesList = new ArrayList<RunesBean>();

	/**
	 * 战斗力
	 */
	private int fightPower;


	public List<RunesBean> getRunesList() {
		return runesList;
	}

	public void setRunesList(List<RunesBean> runesList) {
		this.runesList = runesList;
	}

	public int getFightPower() {
		return fightPower;
	}

	public void setFightPower(int fightPower) {
		this.fightPower = fightPower;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		int runesListLength = readShort(buf);
		for (int runesListI = 0; runesListI < runesListLength; runesListI++) {
			if (readByte(buf) == 0) { 
				this.runesList.add(null);
			} else {
				RunesBean runesBean = new RunesBean();
				runesBean.read(buf);
				this.runesList.add(runesBean);
			}
		}

		this.fightPower = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.runesList.size());
		for (int runesListI = 0; runesListI < this.runesList.size(); runesListI++) {
			this.writeBean(buf, this.runesList.get(runesListI));
		}

		this.writeInt(buf, fightPower, false);

		return true;
	}
}

