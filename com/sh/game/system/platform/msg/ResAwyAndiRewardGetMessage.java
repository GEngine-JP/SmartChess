package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>是否领取过爱微游实名认证奖励（需要上线发给客户端）</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResAwyAndiRewardGetMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAwyAndiRewardGetMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44011;
	}
	
	/**
	 * 1领取过 0没有领取过
	 */
	private int isGet;


	public int getIsGet() {
		return isGet;
	}

	public void setIsGet(int isGet) {
		this.isGet = isGet;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.isGet = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, isGet, false);

		return true;
	}
}

