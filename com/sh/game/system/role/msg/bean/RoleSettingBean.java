package com.sh.game.system.role.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class RoleSettingBean extends KryoBean {

	/**
	 * 设置类型 区分设置项
	 */
	private int settingType;
	/**
	 * 参数 职业等
	 */
	private int parameter;
	/**
	 * 设置的值1选中
	 */
	private int value;

	public int getSettingType() {
		return settingType;
	}

	public void setSettingType(int settingType) {
		this.settingType = settingType;
	}

		public int getParameter() {
		return parameter;
	}

	public void setParameter(int parameter) {
		this.parameter = parameter;
	}

		public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.settingType = readInt(buf, false);
		this.parameter = readInt(buf, false);
		this.value = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, settingType, false);
		this.writeInt(buf, parameter, false);
		this.writeInt(buf, value, false);
		return true;
	}
}
