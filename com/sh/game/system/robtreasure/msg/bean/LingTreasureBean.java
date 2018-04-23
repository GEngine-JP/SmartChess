package com.sh.game.system.robtreasure.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class LingTreasureBean extends KryoBean {

	/**
	 * 灵宝id
	 */
	private int treasureId;
	/**
	 * 碎片数组
	 */
	private List<FragmentBean> fragments = new ArrayList<>();

	public int getTreasureId() {
		return treasureId;
	}

	public void setTreasureId(int treasureId) {
		this.treasureId = treasureId;
	}

		public List<FragmentBean> getFragments() {
		return fragments;
	}

	public void setFragments(List<FragmentBean> fragments) {
		this.fragments = fragments;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.treasureId = readInt(buf, false);
		int fragmentsLength = readShort(buf);
		for (int fragmentsI = 0; fragmentsI < fragmentsLength; fragmentsI++) {
			if (readByte(buf) == 0) { 
				this.fragments.add(null);
			} else {
				FragmentBean fragmentBean = new FragmentBean();
				fragmentBean.read(buf);
				this.fragments.add(fragmentBean);
			}
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, treasureId, false);
		writeShort(buf, this.fragments.size());
		for (int fragmentsI = 0; fragmentsI < this.fragments.size(); fragmentsI++) {
			this.writeBean(buf, this.fragments.get(fragmentsI));
		}
		return true;
	}
}
