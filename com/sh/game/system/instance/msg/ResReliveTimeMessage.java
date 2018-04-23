package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>复活时间</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResReliveTimeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResReliveTimeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20026;
	}
	
	/**
	 * 副本唯一id
	 */
	private int uniqueId;
	/**
	 * 复活的时间戳（秒）
	 */
	private int reliveTime;

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

		public int getReliveTime() {
		return reliveTime;
	}

	public void setReliveTime(int reliveTime) {
		this.reliveTime = reliveTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.uniqueId = readInt(buf, false);
		this.reliveTime = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, uniqueId, false);
		this.writeInt(buf, reliveTime, false);
		return true;
	}
}
