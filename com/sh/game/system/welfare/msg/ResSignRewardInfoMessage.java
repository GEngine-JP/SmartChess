package com.sh.game.system.welfare.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.welfare.msg.bean.SignBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送签到领奖信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSignRewardInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSignRewardInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 27001;
	}
	
	/**
	 * 签到列表
	 */
	private List<SignBean> signBeanList = new ArrayList<>();

	public List<SignBean> getSignBeanList() {
		return signBeanList;
	}

	public void setSignBeanList(List<SignBean> signBeanList) {
		this.signBeanList = signBeanList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int signBeanListLength = readShort(buf);
		for (int signBeanListI = 0; signBeanListI < signBeanListLength; signBeanListI++) {
			if (readByte(buf) == 0) { 
				this.signBeanList.add(null);
			} else {
				SignBean signBean = new SignBean();
				signBean.read(buf);
				this.signBeanList.add(signBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.signBeanList.size());
		for (int signBeanListI = 0; signBeanListI < this.signBeanList.size(); signBeanListI++) {
			this.writeBean(buf, this.signBeanList.get(signBeanListI));
		}
		return true;
	}
}
