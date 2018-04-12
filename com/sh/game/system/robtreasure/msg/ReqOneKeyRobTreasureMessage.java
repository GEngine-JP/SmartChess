package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求一键夺宝</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqOneKeyRobTreasureMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOneKeyRobTreasureMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50010;
	}
	
	/**
	 * 宝物id
	 */
	private int itemId;

	/**
	 * 是否自动使用精力丹补充精力 1.是 0.否
	 */
	private int state;


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.itemId = readInt(buf, false);
		this.state = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, state, false);

		return true;
	}
}

