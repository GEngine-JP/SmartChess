package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>爱微游</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResAhyLastShareTimeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAhyLastShareTimeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44008;
	}
	
	/**
	 * 上次分享时间
	 */
	private int lastShareTime;
	/**
	 * 己分享次数
	 */
	private int shareCount;

	public int getLastShareTime() {
		return lastShareTime;
	}

	public void setLastShareTime(int lastShareTime) {
		this.lastShareTime = lastShareTime;
	}

		public int getShareCount() {
		return shareCount;
	}

	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.lastShareTime = readInt(buf, false);
		this.shareCount = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, lastShareTime, false);
		this.writeInt(buf, shareCount, false);
		return true;
	}
}
