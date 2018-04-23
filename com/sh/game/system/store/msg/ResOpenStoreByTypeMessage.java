package com.sh.game.system.store.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.store.msg.bean.StoreInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回商店商品列表</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResOpenStoreByTypeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOpenStoreByTypeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 16003;
	}
	
	/**
	 * 0、不可刷新 1、可刷新
	 */
	private int state;
	/**
	 * 下次刷新时间
	 */
	private int nextFreshTime;
	/**
	 * 商店分类
	 */
	private int storeClassId;
	/**
	 * 商品列表信息
	 */
	private List<StoreInfo> storeInfo = new ArrayList<>();

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

		public int getNextFreshTime() {
		return nextFreshTime;
	}

	public void setNextFreshTime(int nextFreshTime) {
		this.nextFreshTime = nextFreshTime;
	}

		public int getStoreClassId() {
		return storeClassId;
	}

	public void setStoreClassId(int storeClassId) {
		this.storeClassId = storeClassId;
	}

		public List<StoreInfo> getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(List<StoreInfo> storeInfo) {
		this.storeInfo = storeInfo;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.state = readInt(buf, false);
		this.nextFreshTime = readInt(buf, false);
		this.storeClassId = readInt(buf, false);
		int storeInfoLength = readShort(buf);
		for (int storeInfoI = 0; storeInfoI < storeInfoLength; storeInfoI++) {
			if (readByte(buf) == 0) { 
				this.storeInfo.add(null);
			} else {
				StoreInfo storeInfo = new StoreInfo();
				storeInfo.read(buf);
				this.storeInfo.add(storeInfo);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, state, false);
		this.writeInt(buf, nextFreshTime, false);
		this.writeInt(buf, storeClassId, false);
		writeShort(buf, this.storeInfo.size());
		for (int storeInfoI = 0; storeInfoI < this.storeInfo.size(); storeInfoI++) {
			this.writeBean(buf, this.storeInfo.get(storeInfoI));
		}
		return true;
	}
}
