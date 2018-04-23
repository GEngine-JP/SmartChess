package com.sh.game.system.legacyEquip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.legacyEquip.msg.bean.ShenZhuangBean;

/**
 * <p>返回神装信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResShenZhuangInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResShenZhuangInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 19009;
	}
	
	/**
	 * 神装
	 */
	private ShenZhuangBean shenZhuangBean;
	/**
	 * 战斗力
	 */
	private int fightValue;

	public ShenZhuangBean getShenZhuangBean() {
		return shenZhuangBean;
	}

	public void setShenZhuangBean(ShenZhuangBean shenZhuangBean) {
		this.shenZhuangBean = shenZhuangBean;
	}

		public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			ShenZhuangBean shenZhuangBean = new ShenZhuangBean();
			shenZhuangBean.read(buf);
			this.shenZhuangBean = shenZhuangBean;
		}
		this.fightValue = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, shenZhuangBean);
		this.writeInt(buf, fightValue, false);
		return true;
	}
}
