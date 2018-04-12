package com.sh.game.system.duobao.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求一键夺宝</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqOnekeyDuobaoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOnekeyDuobaoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48010;
	}
	
	/**
	 * 宝物id
	 */
	private int itemId;

	/**
	 * 是否自动使用精力丹补充精力 1.是 2.否
	 */
	private boolean state;


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	
	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.itemId = readInt(buf, false);
		this.state = readBoolean(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, itemId, false);
		this.writeBoolean(buf, state);

		return true;
	}
}

