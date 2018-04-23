package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.robtreasure.msg.bean.FragmentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回夺宝信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRobTreasureInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRobTreasureInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50002;
	}
	
	/**
	 * 碎片
	 */
	private List<FragmentBean> fragmentList = new ArrayList<>();
	/**
	 * 免战牌结束时间戳
	 */
	private int endTime;

	public List<FragmentBean> getFragmentList() {
		return fragmentList;
	}

	public void setFragmentList(List<FragmentBean> fragmentList) {
		this.fragmentList = fragmentList;
	}
	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int fragmentListLength = readShort(buf);
		for (int fragmentListI = 0; fragmentListI < fragmentListLength; fragmentListI++) {
			if (readByte(buf) == 0) { 
				this.fragmentList.add(null);
			} else {
				FragmentBean fragmentBean = new FragmentBean();
				fragmentBean.read(buf);
				this.fragmentList.add(fragmentBean);
			}
		}		this.endTime = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.fragmentList.size());
		for (int fragmentListI = 0; fragmentListI < this.fragmentList.size(); fragmentListI++) {
			this.writeBean(buf, this.fragmentList.get(fragmentListI));
		}		this.writeInt(buf, endTime, false);
		return true;
	}
}
