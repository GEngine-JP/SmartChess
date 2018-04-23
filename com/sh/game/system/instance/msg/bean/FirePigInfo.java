package com.sh.game.system.instance.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class FirePigInfo extends KryoBean {

	/**
	 * 当前倍数
	 */
	private int multi;
	/**
	 * 应得经验值
	 */
	private long exp;

	public int getMulti() {
		return multi;
	}

	public void setMulti(int multi) {
		this.multi = multi;
	}

		public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.multi = readInt(buf, false);
		this.exp = readLong(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, multi, false);
		this.writeLong(buf, exp);
		return true;
	}
}
