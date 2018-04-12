package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>角色设置</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqRoleSettingMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRoleSettingMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8023;
	}
	
	/**
	 * 设置类型
	 */
	private int settingType;

	/**
	 * 参数
	 */
	private int parameter;

	/**
	 * 要修改的值1选中
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

