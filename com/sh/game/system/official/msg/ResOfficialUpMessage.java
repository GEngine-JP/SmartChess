package com.sh.game.system.official.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回官职晋升结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResOfficialUpMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOfficialUpMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 56003;
	}
	
	/**
	 * 职级
	 */
	private int officialGrade;

	public int getOfficialGrade() {
		return officialGrade;
	}

	public void setOfficialGrade(int officialGrade) {
		this.officialGrade = officialGrade;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.officialGrade = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, officialGrade, false);
		return true;
	}
}
