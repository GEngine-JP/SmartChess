package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>通知玩家英雄经验发生变化</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHeroExpChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroExpChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22005;
	}
	
	/**
	 * 当前经验
	 */
	private long curExp;
	/**
	 * 经验来源
	 */
	private int logAction;
	/**
	 * 增加的经验
	 */
	private long addExp;

	public long getCurExp() {
		return curExp;
	}

	public void setCurExp(long curExp) {
		this.curExp = curExp;
	}

		public int getLogAction() {
		return logAction;
	}

	public void setLogAction(int logAction) {
		this.logAction = logAction;
	}

		public long getAddExp() {
		return addExp;
	}

	public void setAddExp(long addExp) {
		this.addExp = addExp;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.curExp = readLong(buf);
		this.logAction = readInt(buf, false);
		this.addExp = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, curExp);
		this.writeInt(buf, logAction, false);
		this.writeLong(buf, addExp);
		return true;
	}
}
