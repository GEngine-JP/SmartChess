package com.sh.game.system.wing.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>金币升级光冀的次数</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResGoldLvCountMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResGoldLvCountMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 18013;
	}
	
	/**
	 * count
	 */
	private int lvCount;

	public int getLvCount() {
		return lvCount;
	}

	public void setLvCount(int lvCount) {
		this.lvCount = lvCount;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.lvCount = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, lvCount, false);
		return true;
	}
}
