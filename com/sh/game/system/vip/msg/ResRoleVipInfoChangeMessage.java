package com.sh.game.system.vip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>通知玩家vip等级发生变化</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRoleVipInfoChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRoleVipInfoChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 28005;
	}
	
	/**
	 * 当前经验
	 */
	private int curExp;
	/**
	 * 当前等级
	 */
	private int curLevel;

	public int getCurExp() {
		return curExp;
	}

	public void setCurExp(int curExp) {
		this.curExp = curExp;
	}

		public int getCurLevel() {
		return curLevel;
	}

	public void setCurLevel(int curLevel) {
		this.curLevel = curLevel;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.curExp = readInt(buf, false);
		this.curLevel = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, curExp, false);
		this.writeInt(buf, curLevel, false);
		return true;
	}
}
