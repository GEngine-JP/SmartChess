package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>使用道具返回消息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResUseItemMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResUseItemMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10005;
	}
	
	/**
	 * 道具id
	 */
	private int itemId;


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.itemId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, itemId, false);

		return true;
	}
}

