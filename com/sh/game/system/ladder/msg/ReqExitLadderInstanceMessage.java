package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求主动退出副本</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqExitLadderInstanceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqExitLadderInstanceMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5016;
	}
	
	/**
	 * 副本唯一id
	 */
	private int instanceId;
	/**
	 * 播放进度
	 */
	private int currentTime;

	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

		public int getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.instanceId = readInt(buf, false);
		this.currentTime = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, instanceId, false);
		this.writeInt(buf, currentTime, false);
		return true;
	}
}
