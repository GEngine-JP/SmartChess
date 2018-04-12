package com.sh.game.system.wing.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class WingBean extends KryoBean {

	/**
	 * 光翼id
	 */
	private int wingId;

	/**
	 * 当前祝福值
	 */
	private int blessingValue;

	/**
	 * 直升丹已使用数量
	 */
	private int danNum;


	public int getWingId() {
		return wingId;
	}

	public void setWingId(int wingId) {
		this.wingId = wingId;
	}

	
	public int getBlessingValue() {
		return blessingValue;
	}

	public void setBlessingValue(int blessingValue) {
		this.blessingValue = blessingValue;
	}

	
	public int getDanNum() {
		return danNum;
	}

	public void setDanNum(int danNum) {
		this.danNum = danNum;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.wingId = readInt(buf, false);
		this.blessingValue = readInt(buf, false);
		this.danNum = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, wingId, false);
		this.writeInt(buf, blessingValue, false);
		this.writeInt(buf, danNum, false);

		return true;
	}
}

