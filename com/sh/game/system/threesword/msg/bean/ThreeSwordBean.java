package com.sh.game.system.threesword.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ThreeSwordBean extends KryoBean {

	/**
	 * 三才装备类型
	 */
	private int type;

	/**
	 * 三才装备id
	 */
	private int itemId;


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.itemId = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeInt(buf, itemId, false);

		return true;
	}
}

