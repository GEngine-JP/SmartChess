package com.sh.game.system.achievement.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class AchievementBean extends KryoBean {

	/**
	 * 成就id
	 */
	private int id;

	/**
	 * 状态 1未完成 2已完成 3 已领奖
	 */
	private int state;

	/**
	 * 进度
	 */
	private int value;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.id = readInt(buf, false);
		this.state = readInt(buf, false);
		this.value = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, id, false);
		this.writeInt(buf, state, false);
		this.writeInt(buf, value, false);

		return true;
	}
}

