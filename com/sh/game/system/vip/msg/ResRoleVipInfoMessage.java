package com.sh.game.system.vip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>vip数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRoleVipInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRoleVipInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 28006;
	}
	
	/**
	 * vip等级
	 */
	private int level;
	/**
	 * vip经验
	 */
	private int exp;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

		public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.level = readInt(buf, false);
		this.exp = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, level, false);
		this.writeInt(buf, exp, false);
		return true;
	}
}
