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
	 * buff类型
	 */
	private int bufferType;
	/**
	 * 效果
	 */
	private int effect;

	public int getBufferType() {
		return bufferType;
	}

	public void setBufferType(int bufferType) {
		this.bufferType = bufferType;
	}

		public int getEffect() {
		return effect;
	}

	public void setEffect(int effect) {
		this.effect = effect;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.bufferType = readInt(buf, false);
		this.effect = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, bufferType, false);
		this.writeInt(buf, effect, false);
		return true;
	}
}
