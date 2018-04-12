package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>通知玩家英雄等级发生变化</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResHeroLevelChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroLevelChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22004;
	}
	
	/**
	 * 玩家id
	 */
	private long uid;

	/**
	 * 当前英雄经验
	 */
	private long curExp;

	/**
	 * 当前英雄等级
	 */
	private int curLevel;


	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	
	public long getCurExp() {
		return curExp;
	}

	public void setCurExp(long curExp) {
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
		this.uid = readLong(buf);
		this.curExp = readLong(buf);
		this.curLevel = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, uid);
		this.writeLong(buf, curExp);
		this.writeInt(buf, curLevel, false);

		return true;
	}
}

