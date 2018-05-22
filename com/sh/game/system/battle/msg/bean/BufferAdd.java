package com.sh.game.system.battle.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class BufferAdd extends KryoBean {

	/**
	 * buff的id
	 */
	private int bufferId;
	/**
	 * 效果
	 */
	private int effect;

	public int getBufferId() {
		return bufferId;
	}

	public void setBufferId(int bufferId) {
		this.bufferId = bufferId;
	}

		public int getEffect() {
		return effect;
	}

	public void setEffect(int effect) {
		this.effect = effect;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.bufferId = readInt(buf, false);
		this.effect = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, bufferId, false);
		this.writeInt(buf, effect, false);
		return true;
	}
}
