package com.sh.game.system.hunt.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>一键使用所有经验丹</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqOneKeyUseDanMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOneKeyUseDanMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 11008;
	}
	
	/**
	 * 使用类型 1、寻宝仓库 2、背包道具
	 */
	private int useType;


	public int getUseType() {
		return useType;
	}

	public void setUseType(int useType) {
		this.useType = useType;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.useType = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, useType, false);

		return true;
	}
}

