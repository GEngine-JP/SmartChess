package com.sh.game.system.xinfa.msg.bean;

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

public class RoleHeartMethodBean extends KryoBean {

	/**
	 * 心法信息
	 */
	private List<HeartMethodBean> methodBeans = new ArrayList<>();
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 角色1英雄2
	 */
	private int type;

	public List<HeartMethodBean> getMethodBeans() {
		return methodBeans;
	}

	public void setMethodBeans(List<HeartMethodBean> methodBeans) {
		this.methodBeans = methodBeans;
	}
	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

		public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int methodBeansLength = readShort(buf);
		for (int methodBeansI = 0; methodBeansI < methodBeansLength; methodBeansI++) {
			if (readByte(buf) == 0) { 
				this.methodBeans.add(null);
			} else {
				HeartMethodBean heartMethodBean = new HeartMethodBean();
				heartMethodBean.read(buf);
				this.methodBeans.add(heartMethodBean);
			}
		}		this.heroId = readLong(buf);
		this.type = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.methodBeans.size());
		for (int methodBeansI = 0; methodBeansI < this.methodBeans.size(); methodBeansI++) {
			this.writeBean(buf, this.methodBeans.get(methodBeansI));
		}		this.writeLong(buf, heroId);
		this.writeInt(buf, type, false);
		return true;
	}
}
