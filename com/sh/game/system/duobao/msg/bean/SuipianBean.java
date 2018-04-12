package com.sh.game.system.duobao.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class SuipianBean extends KryoBean {

	/**
	 * 碎片id
	 */
	private int suipianid;

	/**
	 * 碎片数量
	 */
	private int count;


	public int getSuipianid() {
		return suipianid;
	}

	public void setSuipianid(int suipianid) {
		this.suipianid = suipianid;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.suipianid = readInt(buf, false);
		this.count = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, suipianid, false);
		this.writeInt(buf, count, false);

		return true;
	}
}

