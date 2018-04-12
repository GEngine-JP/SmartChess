package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.back.msg.bean.AutoBanBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回自动禁言列表</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResAutoBanListMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAutoBanListMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43033;
	}
	
	/**
	 * 自动禁言列表
	 */
	private List<AutoBanBean> autoBanBean = new ArrayList<AutoBanBean>();


	public List<AutoBanBean> getAutoBanBean() {
		return autoBanBean;
	}

	public void setAutoBanBean(List<AutoBanBean> autoBanBean) {
		this.autoBanBean = autoBanBean;
	}


	@Override
	public boolean read(KryoInput buf) {
		int autoBanBeanLength = readShort(buf);
		for (int autoBanBeanI = 0; autoBanBeanI < autoBanBeanLength; autoBanBeanI++) {
			if (readByte(buf) == 0) { 
				this.autoBanBean.add(null);
			} else {
				AutoBanBean autoBanBean = new AutoBanBean();
				autoBanBean.read(buf);
				this.autoBanBean.add(autoBanBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.autoBanBean.size());
		for (int autoBanBeanI = 0; autoBanBeanI < this.autoBanBean.size(); autoBanBeanI++) {
			this.writeBean(buf, this.autoBanBean.get(autoBanBeanI));
		}


		return true;
	}
}

