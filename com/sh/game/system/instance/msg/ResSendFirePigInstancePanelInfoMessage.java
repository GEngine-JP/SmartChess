package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送烧猪副本面板信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendFirePigInstancePanelInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendFirePigInstancePanelInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20016;
	}
	
	/**
	 * 剩余挑战次数
	 */
	private int remainNum;

	/**
	 * 副本id
	 */
	private int instanceId;


	public int getRemainNum() {
		return remainNum;
	}

	public void setRemainNum(int remainNum) {
		this.remainNum = remainNum;
	}

	
	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.remainNum = readInt(buf, false);
		this.instanceId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, remainNum, false);
		this.writeInt(buf, instanceId, false);

		return true;
	}
}

