package com.sh.game.system.runes.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.runes.msg.bean.RunesPositionBean;


/**
 * <p>符文洗练</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResRunesImproveMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRunesImproveMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 24006;
	}
	
	/**
	 * 符文洗练
	 */
	private RunesPositionBean runesPositionBean;

	/**
	 * 战斗力
	 */
	private int fightPower;


	public RunesPositionBean getRunesPositionBean() {
		return runesPositionBean;
	}

	public void setRunesPositionBean(RunesPositionBean runesPositionBean) {
		this.runesPositionBean = runesPositionBean;
	}

	
	public int getFightPower() {
		return fightPower;
	}

	public void setFightPower(int fightPower) {
		this.fightPower = fightPower;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		if (readByte(buf) != 0) {
			RunesPositionBean runesPositionBean = new RunesPositionBean();
			runesPositionBean.read(buf);
			this.runesPositionBean = runesPositionBean;
		}
		this.fightPower = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeBean(buf, runesPositionBean);
		this.writeInt(buf, fightPower, false);

		return true;
	}
}

