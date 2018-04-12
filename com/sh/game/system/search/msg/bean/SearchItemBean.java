package com.sh.game.system.search.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;

import com.sh.game.system.search.msg.bean.BestAttBean;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class SearchItemBean extends KryoBean {

	/**
	 * itemId
	 */
	private int itemId;

	/**
	 * 数量
	 */
	private int count;

	/**
	 * 极品属性
	 */
	private BestAttBean bestAttBean;


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	public BestAttBean getBestAttBean() {
		return bestAttBean;
	}

	public void setBestAttBean(BestAttBean bestAttBean) {
		this.bestAttBean = bestAttBean;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.itemId = readInt(buf, false);
		this.count = readInt(buf, false);
		if (readByte(buf) != 0) {
			BestAttBean bestAttBean = new BestAttBean();
			bestAttBean.read(buf);
			this.bestAttBean = bestAttBean;
		}

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, count, false);
		this.writeBean(buf, bestAttBean);

		return true;
	}
}

