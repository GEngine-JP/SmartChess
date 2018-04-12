package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.instance.msg.bean.ItemBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>怪物死亡发送奖励信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendWorldBossRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendWorldBossRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20010;
	}
	
	/**
	 * 奖励列表
	 */
	private List<ItemBean> itemBean = new ArrayList<ItemBean>();

	/**
	 * 奖励类型 1排名者2最后一击3归属者4参与者5召唤者6其他玩家
	 */
	private int type;


	public List<ItemBean> getItemBean() {
		return itemBean;
	}

	public void setItemBean(List<ItemBean> itemBean) {
		this.itemBean = itemBean;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

		this.type = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.itemBean.size());
		for (int itemBeanI = 0; itemBeanI < this.itemBean.size(); itemBeanI++) {
			this.writeBean(buf, this.itemBean.get(itemBeanI));
		}

		this.writeInt(buf, type, false);

		return true;
	}
}

