package com.sh.game.system.godax.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回神斧信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResGodAxInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResGodAxInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 62003;
	}
	
	/**
	 * 神斧id
	 */
	private int godAxId;
	/**
	 * 战力
	 */
	private int fightValue;

	public int getGodAxId() {
		return godAxId;
	}

	public void setGodAxId(int godAxId) {
		this.godAxId = godAxId;
	}

		public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.godAxId = readInt(buf, false);
		this.fightValue = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, godAxId, false);
		this.writeInt(buf, fightValue, false);
		return true;
	}
}
