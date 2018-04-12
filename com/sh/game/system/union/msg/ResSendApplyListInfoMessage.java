package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.union.msg.bean.ApplyListInfoBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送申请入会列表信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendApplyListInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendApplyListInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23012;
	}
	
	/**
	 * 申请列表信息
	 */
	private List<ApplyListInfoBean> applyInfo = new ArrayList<ApplyListInfoBean>();


	public List<ApplyListInfoBean> getApplyInfo() {
		return applyInfo;
	}

	public void setApplyInfo(List<ApplyListInfoBean> applyInfo) {
		this.applyInfo = applyInfo;
	}


	@Override
	public boolean read(KryoInput buf) {
		int applyInfoLength = readShort(buf);
		for (int applyInfoI = 0; applyInfoI < applyInfoLength; applyInfoI++) {
			if (readByte(buf) == 0) { 
				this.applyInfo.add(null);
			} else {
				ApplyListInfoBean applyListInfoBean = new ApplyListInfoBean();
				applyListInfoBean.read(buf);
				this.applyInfo.add(applyListInfoBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.applyInfo.size());
		for (int applyInfoI = 0; applyInfoI < this.applyInfo.size(); applyInfoI++) {
			this.writeBean(buf, this.applyInfo.get(applyInfoI));
		}


		return true;
	}
}

