package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>护盾值变化消息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDunChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDunChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20033;
	}
	
	/**
	 * 当前护盾值
	 */
	private int maxCount;
	/**
	 * 最大护盾值
	 */
	private int dunCount;

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

		public int getDunCount() {
		return dunCount;
	}

	public void setDunCount(int dunCount) {
		this.dunCount = dunCount;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.maxCount = readInt(buf, false);
		this.dunCount = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, maxCount, false);
		this.writeInt(buf, dunCount, false);
		return true;
	}
}
