package com.sh.game.system.xinfa.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.xinfa.msg.bean.RoleHeartMethodBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送心法面板信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendHeartMethodPanelInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendHeartMethodPanelInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 58001;
	}
	
	/**
	 * 心法信息
	 */
	private List<RoleHeartMethodBean> methodBeans = new ArrayList<>();

	public List<RoleHeartMethodBean> getMethodBeans() {
		return methodBeans;
	}

	public void setMethodBeans(List<RoleHeartMethodBean> methodBeans) {
		this.methodBeans = methodBeans;
	}

	@Override
	public boolean read(KryoInput buf) {

		int methodBeansLength = readShort(buf);
		for (int methodBeansI = 0; methodBeansI < methodBeansLength; methodBeansI++) {
			if (readByte(buf) == 0) { 
				this.methodBeans.add(null);
			} else {
				RoleHeartMethodBean roleHeartMethodBean = new RoleHeartMethodBean();
				roleHeartMethodBean.read(buf);
				this.methodBeans.add(roleHeartMethodBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.methodBeans.size());
		for (int methodBeansI = 0; methodBeansI < this.methodBeans.size(); methodBeansI++) {
			this.writeBean(buf, this.methodBeans.get(methodBeansI));
		}
		return true;
	}
}
