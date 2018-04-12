package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送dps改变信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendDpsChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendDpsChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20019;
	}
	
	/**
	 * 副本唯一id
	 */
	private int uniqueId;

	/**
	 * 玩家dps
	 */
	private int dps;


	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	
	public int getDps() {
		return dps;
	}

	public void setDps(int dps) {
		this.dps = dps;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.uniqueId = readInt(buf, false);
		this.dps = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, uniqueId, false);
		this.writeInt(buf, dps, false);

		return true;
	}
}

