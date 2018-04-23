package com.sh.game.system.legacyEquip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.legacyEquip.msg.bean.ShenZhuangBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送所有神装信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResAllShenZhuangInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAllShenZhuangInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 19010;
	}
	
	/**
	 * 神装列表
	 */
	private List<ShenZhuangBean> shenZhuangList = new ArrayList<>();
	/**
	 * 战斗力
	 */
	private int fightValue;

	public List<ShenZhuangBean> getShenZhuangList() {
		return shenZhuangList;
	}

	public void setShenZhuangList(List<ShenZhuangBean> shenZhuangList) {
		this.shenZhuangList = shenZhuangList;
	}
	public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int shenZhuangListLength = readShort(buf);
		for (int shenZhuangListI = 0; shenZhuangListI < shenZhuangListLength; shenZhuangListI++) {
			if (readByte(buf) == 0) { 
				this.shenZhuangList.add(null);
			} else {
				ShenZhuangBean shenZhuangBean = new ShenZhuangBean();
				shenZhuangBean.read(buf);
				this.shenZhuangList.add(shenZhuangBean);
			}
		}		this.fightValue = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.shenZhuangList.size());
		for (int shenZhuangListI = 0; shenZhuangListI < this.shenZhuangList.size(); shenZhuangListI++) {
			this.writeBean(buf, this.shenZhuangList.get(shenZhuangListI));
		}		this.writeInt(buf, fightValue, false);
		return true;
	}
}
