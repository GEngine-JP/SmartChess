package com.sh.game.system.search.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.search.msg.bean.SearchItemBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送探索boss面板奖励信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSearchBossRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSearchBossRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 38008;
	}
	
	/**
	 * 装备
	 */
	private List<SearchItemBean> itemBean = new ArrayList<SearchItemBean>();


	public List<SearchItemBean> getItemBean() {
		return itemBean;
	}

	public void setItemBean(List<SearchItemBean> itemBean) {
		this.itemBean = itemBean;
	}


	@Override
	public boolean read(KryoInput buf) {
		int itemBeanLength = readShort(buf);
		for (int itemBeanI = 0; itemBeanI < itemBeanLength; itemBeanI++) {
			if (readByte(buf) == 0) { 
				this.itemBean.add(null);
			} else {
				SearchItemBean searchItemBean = new SearchItemBean();
				searchItemBean.read(buf);
				this.itemBean.add(searchItemBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.itemBean.size());
		for (int itemBeanI = 0; itemBeanI < this.itemBean.size(); itemBeanI++) {
			this.writeBean(buf, this.itemBean.get(itemBeanI));
		}


		return true;
	}
}

