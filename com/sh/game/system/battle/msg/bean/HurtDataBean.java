package com.sh.game.system.battle.msg.bean;

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

public class HurtDataBean extends KryoBean {

	/**
	 * id
	 */
	private long targetId;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 伤害类型bean
	 */
	private HurtTypeBean hurtTypeBean;
	/**
	 * buff列表
	 */
	private List<BufferAdd> bufferDataBean = new ArrayList<>();

	public long getTargetId() {
		return targetId;
	}

	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		public HurtTypeBean getHurtTypeBean() {
		return hurtTypeBean;
	}

	public void setHurtTypeBean(HurtTypeBean hurtTypeBean) {
		this.hurtTypeBean = hurtTypeBean;
	}

		public List<BufferAdd> getBufferDataBean() {
		return bufferDataBean;
	}

	public void setBufferDataBean(List<BufferAdd> bufferDataBean) {
		this.bufferDataBean = bufferDataBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.targetId = readLong(buf);
		this.name = readString(buf);
		if (readByte(buf) != 0) {
			HurtTypeBean hurtTypeBean = new HurtTypeBean();
			hurtTypeBean.read(buf);
			this.hurtTypeBean = hurtTypeBean;
		}
		int bufferDataBeanLength = readShort(buf);
		for (int bufferDataBeanI = 0; bufferDataBeanI < bufferDataBeanLength; bufferDataBeanI++) {
			if (readByte(buf) == 0) { 
				this.bufferDataBean.add(null);
			} else {
				BufferAdd bufferAdd = new BufferAdd();
				bufferAdd.read(buf);
				this.bufferDataBean.add(bufferAdd);
			}
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, targetId);
		this.writeString(buf, name);
		this.writeBean(buf, hurtTypeBean);
		writeShort(buf, this.bufferDataBean.size());
		for (int bufferDataBeanI = 0; bufferDataBeanI < this.bufferDataBean.size(); bufferDataBeanI++) {
			this.writeBean(buf, this.bufferDataBean.get(bufferDataBeanI));
		}
		return true;
	}
}
