package com.sh.game.system.vip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求领取vip礼包</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqBuyVipRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBuyVipRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 28004;
	}
	
	/**
	 * vip等级
	 */
	private int vipLevel;

	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.vipLevel = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, vipLevel, false);
		return true;
	}
}
