package com.sh.game.system.threesword.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求升级三才装备</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqLevelUpThreeSwordInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLevelUpThreeSwordInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 46002;
	}
	
	/**
	 * 三才装备类型
	 */
	private int index;


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.index = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, index, false);

		return true;
	}
}

