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

public class ResOfficialPointChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOfficialPointChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 56006;
	}
	
	/**
	 * 历练点
	 */
	private int officialPoint;

	public int getOfficialPoint() {
		return officialPoint;
	}

	public void setOfficialPoint(int officialPoint) {
		this.officialPoint = officialPoint;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.officialPoint = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, officialPoint, false);
		return true;
	}
}
