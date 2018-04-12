package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>通知烧猪副本boss死亡</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqNoticeFirePigInstanceBossDieMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqNoticeFirePigInstanceBossDieMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20017;
	}
	
	/**
	 * 副本唯一id
	 */
	private int uniqueId;


	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.uniqueId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, uniqueId, false);

		return true;
	}
}

