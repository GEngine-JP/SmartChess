package com.sh.game.system.xiandan.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class XianDanInfoBean extends KryoBean {

	/**
	 * 仙丹id
	 */
	private int xianDanId;
	/**
	 * 数量
	 */
	private int count;

	public int getXianDanId() {
		return xianDanId;
	}

	public void setXianDanId(int xianDanId) {
		this.xianDanId = xianDanId;
	}

		public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.xianDanId = readInt(buf, false);
		this.count = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, xianDanId, false);
		this.writeInt(buf, count, false);
		return true;
	}
}
