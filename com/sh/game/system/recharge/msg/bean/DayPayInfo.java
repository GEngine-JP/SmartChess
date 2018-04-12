package com.sh.game.system.recharge.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class DayPayInfo extends KryoBean {

	/**
	 * sequence
	 */
	private int sequence;

	/**
	 * 领取状态 0不可领取 1可领取 2已领取
	 */
	private int state;


	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.sequence = readInt(buf, false);
		this.state = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, sequence, false);
		this.writeInt(buf, state, false);

		return true;
	}
}

