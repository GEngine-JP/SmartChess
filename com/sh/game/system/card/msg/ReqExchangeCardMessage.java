package com.sh.game.system.card.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>兑换卡片信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqExchangeCardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqExchangeCardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 51001;
	}
	
	/**
	 * 要兑换的卡片id
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
