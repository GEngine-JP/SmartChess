package com.sh.game.system.union.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class UnionSettingBean extends KryoBean {

	/**
	 * 设置类型
	 */
	private int settingType;

	/**
	 * 值 (如果是boolean 1为true,0为false)
	 */
	private int value;

	/**
	 * 额外参数 (万分比)
	 */
	private int extraParam;


	public int getSettingType() {
		return settingType;
	}

	public void setSettingType(int settingType) {
		this.settingType = settingType;
	}

	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
	public int getExtraParam() {
		return extraParam;
	}

	public void setExtraParam(int extraParam) {
		this.extraParam = extraParam;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.settingType = readInt(buf, false);
		this.value = readInt(buf, false);
		this.extraParam = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, settingType, false);
		this.writeInt(buf, value, false);
		this.writeInt(buf, extraParam, false);

		return true;
	}
}

