package com.sh.game.system.official.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送历练点</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResTotalPointChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResTotalPointChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 56006;
	}
	
	/**
	 * 历练点
	 */
	private int totalPoint;

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.totalPoint = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, totalPoint, false);
		return true;
	}
}
