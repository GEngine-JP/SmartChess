package com.sh.game.system.chat.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class BestAttBean extends KryoBean {

	/**
	 * 属性id
	 */
	private int attId;

	/**
	 * 属性类型
	 */
	private int attType;

	/**
	 * 值
	 */
	private int value;

	/**
	 * 参数
	 */
	private int param;

	/**
	 * 战力
	 */
	private int power;


	public int getAttId() {
		return attId;
	}

	public void setAttId(int attId) {
		this.attId = attId;
	}

	
	public int getAttType() {
		return attType;
	}

	public void setAttType(int attType) {
		this.attType = attType;
	}

	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
	public int getParam() {
		return param;
	}

	public void setParam(int param) {
		this.param = param;
	}

	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.attId = readInt(buf, false);
		this.attType = readInt(buf, false);
		this.value = readInt(buf, false);
		this.param = readInt(buf, false);
		this.power = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, attId, false);
		this.writeInt(buf, attType, false);
		this.writeInt(buf, value, false);
		this.writeInt(buf, param, false);
		this.writeInt(buf, power, false);

		return true;
	}
}

