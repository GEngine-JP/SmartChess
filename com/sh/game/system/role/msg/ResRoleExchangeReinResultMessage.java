package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送角色兑换修为结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRoleExchangeReinResultMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRoleExchangeReinResultMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8010;
	}
	
	/**
	 * 当前修为
	 */
	private int reinNum;
	/**
	 * 剩余兑换次数
	 */
	private int exchangeNum;
	/**
	 * 兑换后角色等级
	 */
	private int roleLevel;

	public int getReinNum() {
		return reinNum;
	}

	public void setReinNum(int reinNum) {
		this.reinNum = reinNum;
	}

		public int getExchangeNum() {
		return exchangeNum;
	}

	public void setExchangeNum(int exchangeNum) {
		this.exchangeNum = exchangeNum;
	}

		public int getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(int roleLevel) {
		this.roleLevel = roleLevel;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.reinNum = readInt(buf, false);
		this.exchangeNum = readInt(buf, false);
		this.roleLevel = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, reinNum, false);
		this.writeInt(buf, exchangeNum, false);
		this.writeInt(buf, roleLevel, false);
		return true;
	}
}
