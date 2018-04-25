package com.sh.game.system.treasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送宝物穿戴信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHeroPutOnTreasureInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroPutOnTreasureInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 14018;
	}
	
	/**
	 * 0.未穿戴 1.神弓 2.神斧 3.神剑 4.法宝
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
