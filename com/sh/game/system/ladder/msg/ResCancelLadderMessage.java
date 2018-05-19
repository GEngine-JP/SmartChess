package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>取消匹配</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResCancelLadderMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCancelLadderMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5004;
	}
	
	/**
	 * 1 取消成功 2取消失败
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
