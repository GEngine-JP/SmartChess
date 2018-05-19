package com.sh.game.system.search.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求操作探索事件</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqStartSearchEventMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqStartSearchEventMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 38007;
	}
	
	/**
	 * 事件的位置
	 */
	private int position;

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.position = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, position, false);
		return true;
	}
}
