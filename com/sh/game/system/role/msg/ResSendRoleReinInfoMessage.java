package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.role.msg.bean.ReinItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送角色转生信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendRoleReinInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendRoleReinInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8007;
	}
	
	/**
	 * 转生配置表id
	 */
	private int cfgId;
	/**
	 * 当前修为
	 */
	private int reinNum;
	/**
	 * 战斗力
	 */
	private int fightValue;
	/**
	 * 剩余兑换次数
	 */
	private int exchangeNum;
	/**
	 * 修为丹已使用次数
	 */
	private List<ReinItemBean> useNum = new ArrayList<>();

	public int getCfgId() {
		return cfgId;
	}

	public void setCfgId(int cfgId) {
		this.cfgId = cfgId;
	}

		public int getReinNum() {
		return reinNum;
	}

	public void setReinNum(int reinNum) {
		this.reinNum = reinNum;
	}

		public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

		public int getExchangeNum() {
		return exchangeNum;
	}

	public void setExchangeNum(int exchangeNum) {
		this.exchangeNum = exchangeNum;
	}

		public List<ReinItemBean> getUseNum() {
		return useNum;
	}

	public void setUseNum(List<ReinItemBean> useNum) {
		this.useNum = useNum;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.cfgId = readInt(buf, false);
		this.reinNum = readInt(buf, false);
		this.fightValue = readInt(buf, false);
		this.exchangeNum = readInt(buf, false);
		int useNumLength = readShort(buf);
		for (int useNumI = 0; useNumI < useNumLength; useNumI++) {
			if (readByte(buf) == 0) { 
				this.useNum.add(null);
			} else {
				ReinItemBean reinItemBean = new ReinItemBean();
				reinItemBean.read(buf);
				this.useNum.add(reinItemBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, cfgId, false);
		this.writeInt(buf, reinNum, false);
		this.writeInt(buf, fightValue, false);
		this.writeInt(buf, exchangeNum, false);
		writeShort(buf, this.useNum.size());
		for (int useNumI = 0; useNumI < this.useNum.size(); useNumI++) {
			this.writeBean(buf, this.useNum.get(useNumI));
		}
		return true;
	}
}
