package com.sh.game.system.fight.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求更改攻击模式</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqChangeAttackPatternMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqChangeAttackPatternMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 25009;
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
