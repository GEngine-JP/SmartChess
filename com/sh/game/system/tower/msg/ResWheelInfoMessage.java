package com.sh.game.system.tower.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.tower.msg.bean.WheelBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回转盘信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResWheelInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResWheelInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 54007;
	}
	
	/**
	 * 排行信息
	 */
	private List<WheelBean> wheelBeanList = new ArrayList<>();

	public List<WheelBean> getWheelBeanList() {
		return wheelBeanList;
	}

	public void setWheelBeanList(List<WheelBean> wheelBeanList) {
		this.wheelBeanList = wheelBeanList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int wheelBeanListLength = readShort(buf);
		for (int wheelBeanListI = 0; wheelBeanListI < wheelBeanListLength; wheelBeanListI++) {
			if (readByte(buf) == 0) { 
				this.wheelBeanList.add(null);
			} else {
				WheelBean wheelBean = new WheelBean();
				wheelBean.read(buf);
				this.wheelBeanList.add(wheelBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.wheelBeanList.size());
		for (int wheelBeanListI = 0; wheelBeanListI < this.wheelBeanList.size(); wheelBeanListI++) {
			this.writeBean(buf, this.wheelBeanList.get(wheelBeanListI));
		}
		return true;
	}
}
