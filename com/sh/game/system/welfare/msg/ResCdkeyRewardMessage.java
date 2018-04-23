package com.sh.game.system.welfare.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回cdkey领奖结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResCdkeyRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCdkeyRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 27004;
	}
	
	/**
	 * lang表id
	 */
	private int result;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.result = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, result, false);
		return true;
	}
}
