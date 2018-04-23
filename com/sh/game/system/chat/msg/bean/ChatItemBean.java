package com.sh.game.system.chat.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ChatItemBean extends KryoBean {

	/**
	 * 道具唯一id
	 */
	private long uniqueId;
	/**
	 * 道具id
	 */
	private int itemId;
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
	/**
	 * 配置表id
	 */
	private int configId;

	public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

		public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

		public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.uniqueId = readLong(buf);
		this.itemId = readInt(buf, false);
		this.attType = readInt(buf, false);
		this.value = readInt(buf, false);
		this.param = readInt(buf, false);
		this.power = readInt(buf, false);
		this.configId = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, uniqueId);
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, attType, false);
		this.writeInt(buf, value, false);
		this.writeInt(buf, param, false);
		this.writeInt(buf, power, false);
		this.writeInt(buf, configId, false);
		return true;
	}
}
