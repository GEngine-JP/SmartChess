package com.sh.game.system.wing.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class WingTalentBean extends KryoBean {

	/**
	 * 资质类型
	 */
	private int cls;
	/**
	 * 等级
	 */
	private int level;

	public int getCls() {
		return cls;
	}

	public void setCls(int cls) {
		this.cls = cls;
	}

		public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.cls = readInt(buf, false);
		this.level = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, cls, false);
		this.writeInt(buf, level, false);
		return true;
	}
}
