package com.sh.game.system.task.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求领取精英任务奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetEliteTaskRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetEliteTaskRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 42005;
	}
	
	/**
	 * 领取倍数
	 */
	private int multi;


	public int getMulti() {
		return multi;
	}

	public void setMulti(int multi) {
		this.multi = multi;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.multi = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, multi, false);

		return true;
	}
}

