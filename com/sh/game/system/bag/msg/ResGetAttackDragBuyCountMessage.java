package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.bag.msg.bean.InstanceItemBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回次数</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResGetAttackDragBuyCountMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResGetAttackDragBuyCountMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10012;
	}
	
	/**
	 * 道具使用信息
	 */
	private List<InstanceItemBean> useInfo = new ArrayList<InstanceItemBean>();


	public List<InstanceItemBean> getUseInfo() {
		return useInfo;
	}

	public void setUseInfo(List<InstanceItemBean> useInfo) {
		this.useInfo = useInfo;
	}


	@Override
	public boolean read(KryoInput buf) {
		int useInfoLength = readShort(buf);
		for (int useInfoI = 0; useInfoI < useInfoLength; useInfoI++) {
			if (readByte(buf) == 0) { 
				this.useInfo.add(null);
			} else {
				InstanceItemBean instanceItemBean = new InstanceItemBean();
				instanceItemBean.read(buf);
				this.useInfo.add(instanceItemBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.useInfo.size());
		for (int useInfoI = 0; useInfoI < this.useInfo.size(); useInfoI++) {
			this.writeBean(buf, this.useInfo.get(useInfoI));
		}


		return true;
	}
}

