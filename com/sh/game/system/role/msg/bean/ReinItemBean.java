package com.sh.game.system.role.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReinItemBean extends KryoBean {

	/**
	 * 道具id
	 */
	private int itemId;
	/**
	 * 已使用次数
	 */
	private int useNum;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

		public int getUseNum() {
		return useNum;
	}

	public void setUseNum(int useNum) {
		this.useNum = useNum;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.itemId = readInt(buf, false);
		this.useNum = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, itemId, false);
		this.writeInt(buf, useNum, false);
		return true;
	}
}
