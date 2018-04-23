package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回当前击杀小怪波数</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendKillMonsterWaveMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendKillMonsterWaveMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20013;
	}
	
	/**
	 * 当前击杀波数
	 */
	private int wave;

	public int getWave() {
		return wave;
	}

	public void setWave(int wave) {
		this.wave = wave;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.wave = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, wave, false);
		return true;
	}
}
