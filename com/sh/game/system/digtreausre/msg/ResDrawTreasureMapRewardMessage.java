package com.sh.game.system.digtreausre.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.digtreausre.msg.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>领取藏宝图结果返回</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDrawTreasureMapRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDrawTreasureMapRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 65002;
	}
	
	/**
	 * 道具列表
	 */
	private List<ItemBean> itemBean = new ArrayList<>();

	public List<ItemBean> getItemBean() {
		return itemBean;
	}

	public void setItemBean(List<ItemBean> itemBean) {
		this.itemBean = itemBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		int itemBeanLength = readShort(buf);
		for (int itemBeanI = 0; itemBeanI < itemBeanLength; itemBeanI++) {
			if (readByte(buf) == 0) { 
				this.itemBean.add(null);
			} else {
				ItemBean itemBean = new ItemBean();
				itemBean.read(buf);
				this.itemBean.add(itemBean);
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
