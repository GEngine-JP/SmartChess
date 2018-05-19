package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送总战斗力</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResTotalFightValueChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResTotalFightValueChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8011;
	}
	
	/**
	 * 总战斗力
	 */
	private int totalFightValue;

	public int getTotalFightValue() {
		return totalFightValue;
	}

	public void setTotalFightValue(int totalFightValue) {
		this.totalFightValue = totalFightValue;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.totalFightValue = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, totalFightValue, false);
		return true;
	}
}
