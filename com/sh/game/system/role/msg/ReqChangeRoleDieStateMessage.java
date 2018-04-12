package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求改变玩家死亡状态</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqChangeRoleDieStateMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqChangeRoleDieStateMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8016;
	}
	
	/**
	 * 类型 1死亡 2复活
	 */
	private int type;


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);

		return true;
	}
}

