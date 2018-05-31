package com.sh.game.system.activity.msg.bean;

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

public class FirstKillRewardBean extends KryoBean {

	/**
	 * 击杀信息
	 */
	private List<FirstKillBean> killBeans = new ArrayList<>();
	/**
	 * 是否已领奖 0不可领奖1可领奖2已领奖
	 */
	private int reward;

	public List<FirstKillBean> getKillBeans() {
		return killBeans;
	}

	public void setKillBeans(List<FirstKillBean> killBeans) {
		this.killBeans = killBeans;
	}
	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int killBeansLength = readShort(buf);
		for (int killBeansI = 0; killBeansI < killBeansLength; killBeansI++) {
			if (readByte(buf) == 0) { 
				this.killBeans.add(null);
			} else {
				FirstKillBean firstKillBean = new FirstKillBean();
				firstKillBean.read(buf);
				this.killBeans.add(firstKillBean);
			}
		}		this.reward = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.killBeans.size());
		for (int killBeansI = 0; killBeansI < this.killBeans.size(); killBeansI++) {
			this.writeBean(buf, this.killBeans.get(killBeansI));
		}		this.writeInt(buf, reward, false);
		return true;
	}
}
