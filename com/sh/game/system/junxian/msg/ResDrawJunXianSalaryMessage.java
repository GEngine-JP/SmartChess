package com.sh.game.system.junxian.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回领取军衔俸禄结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDrawJunXianSalaryMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDrawJunXianSalaryMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 59005;
	}
	
	/**
	 * 已领取次数
	 */
	private int hasDrawCount;
	/**
	 * 上一次领取时间(s)
	 */
	private int lastDrawTime;

	public int getHasDrawCount() {
		return hasDrawCount;
	}

	public void setHasDrawCount(int hasDrawCount) {
		this.hasDrawCount = hasDrawCount;
	}

		public int getLastDrawTime() {
		return lastDrawTime;
	}

	public void setLastDrawTime(int lastDrawTime) {
		this.lastDrawTime = lastDrawTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.hasDrawCount = readInt(buf, false);
		this.lastDrawTime = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, hasDrawCount, false);
		this.writeInt(buf, lastDrawTime, false);
		return true;
	}
}
