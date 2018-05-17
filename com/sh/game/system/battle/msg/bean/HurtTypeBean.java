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

public class HurtTypeBean extends KryoBean {

	/**
	 * hurtType
	 */
	private int hurtType;
	/**
	 * 效果
	 */
	private int effect;

	public int getHurtType() {
		return hurtType;
	}

	public void setHurtType(int hurtType) {
		this.hurtType = hurtType;
	}

		public int getEffect() {
		return effect;
	}

	public void setEffect(int effect) {
		this.effect = effect;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.hurtType = readInt(buf, false);
		this.effect = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, hurtType, false);
		this.writeInt(buf, effect, false);
		return true;
	}
}
