package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求挑战行会boss（进入副本）</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqEnterUnionBossMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqEnterUnionBossMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20006;
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

