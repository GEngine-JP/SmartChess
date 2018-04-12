package com.sh.game.system.skill.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求激活合击技能前置条件</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqActiveCombineSkillItemsMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqActiveCombineSkillItemsMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 9007;
	}
	
	/**
	 * 前置道具id
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

