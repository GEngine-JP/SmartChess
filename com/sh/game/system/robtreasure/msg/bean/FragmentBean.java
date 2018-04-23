package com.sh.game.system.robtreasure.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class FragmentBean extends KryoBean {

	/**
	 * 碎片id
	 */
	private int fragmentId;
	/**
	 * 碎片数量
	 */
	private int count;

	public int getFragmentId() {
		return fragmentId;
	}

	public void setFragmentId(int fragmentId) {
		this.fragmentId = fragmentId;
	}

		public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.fragmentId = readInt(buf, false);
		this.count = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, fragmentId, false);
		this.writeInt(buf, count, false);
		return true;
	}
}
