package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>通知属性发生变化</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResHeroAttributeChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroAttributeChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22002;
	}
	
	/**
	 * 英雄id
	 */
	private long uid;

	/**
	 * 战斗力
	 */
	private int power;

	/**
	 * 属性类型
	 */
	private List<Byte> attributeType = new ArrayList<Byte>();

	/**
	 * 属性值
	 */
	private List<Integer> attributeValue = new ArrayList<Integer>();


	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	
	public List<Byte> getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(List<Byte> attributeType) {
		this.attributeType = attributeType;
	}

	public List<Integer> getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(List<Integer> attributeValue) {
		this.attributeValue = attributeValue;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.uid = readLong(buf);
		this.power = readInt(buf, false);
		int attributeTypeLength = readShort(buf);
		for (int attributeTypeI = 0; attributeTypeI < attributeTypeLength; attributeTypeI++) {
			this.attributeType.add(readByte(buf));
		}

		int attributeValueLength = readShort(buf);
		for (int attributeValueI = 0; attributeValueI < attributeValueLength; attributeValueI++) {
			this.attributeValue.add(this.readInt(buf, false));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, uid);
		this.writeInt(buf, power, false);
		writeShort(buf, this.attributeType.size());
		for (int attributeTypeI = 0; attributeTypeI < this.attributeType.size(); attributeTypeI++) {
			this.writeByte(buf, this.attributeType.get(attributeTypeI));
		}

		writeShort(buf, this.attributeValue.size());
		for (int attributeValueI = 0; attributeValueI < this.attributeValue.size(); attributeValueI++) {
			this.writeInt(buf, this.attributeValue.get(attributeValueI), false);
		}


		return true;
	}
}

