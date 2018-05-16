package com.sh.game.system.wing.msg.bean;

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

public class WingBean extends KryoBean {

	/**
	 * 光翼id
	 */
	private int wingId;
	/**
	 * 当前祝福值
	 */
	private int blessingValue;
	/**
	 * 直升丹已使用数量
	 */
	private int danNum;
	/**
	 * 资质列表
	 */
	private List<WingTalentBean> wingTalentList = new ArrayList<>();

	public int getWingId() {
		return wingId;
	}

	public void setWingId(int wingId) {
		this.wingId = wingId;
	}

		public int getBlessingValue() {
		return blessingValue;
	}

	public void setBlessingValue(int blessingValue) {
		this.blessingValue = blessingValue;
	}

		public int getDanNum() {
		return danNum;
	}

	public void setDanNum(int danNum) {
		this.danNum = danNum;
	}

		public List<WingTalentBean> getWingTalentList() {
		return wingTalentList;
	}

	public void setWingTalentList(List<WingTalentBean> wingTalentList) {
		this.wingTalentList = wingTalentList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.wingId = readInt(buf, false);
		this.blessingValue = readInt(buf, false);
		this.danNum = readInt(buf, false);
		int wingTalentListLength = readShort(buf);
		for (int wingTalentListI = 0; wingTalentListI < wingTalentListLength; wingTalentListI++) {
			if (readByte(buf) == 0) { 
				this.wingTalentList.add(null);
			} else {
				WingTalentBean wingTalentBean = new WingTalentBean();
				wingTalentBean.read(buf);
				this.wingTalentList.add(wingTalentBean);
			}
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, wingId, false);
		this.writeInt(buf, blessingValue, false);
		this.writeInt(buf, danNum, false);
		writeShort(buf, this.wingTalentList.size());
		for (int wingTalentListI = 0; wingTalentListI < this.wingTalentList.size(); wingTalentListI++) {
			this.writeBean(buf, this.wingTalentList.get(wingTalentListI));
		}
		return true;
	}
}
