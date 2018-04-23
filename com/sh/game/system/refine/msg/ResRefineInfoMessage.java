package com.sh.game.system.refine.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.refine.msg.bean.RefineBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回精炼信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRefineInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRefineInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 55001;
	}
	
	/**
	 * 类型 1角色 2英雄
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 战斗力
	 */
	private int fightValue;
	/**
	 * 精炼信息列表
	 */
	private List<RefineBean> refineInfoList = new ArrayList<>();

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

		public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

		public List<RefineBean> getRefineInfoList() {
		return refineInfoList;
	}

	public void setRefineInfoList(List<RefineBean> refineInfoList) {
		this.refineInfoList = refineInfoList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.fightValue = readInt(buf, false);
		int refineInfoListLength = readShort(buf);
		for (int refineInfoListI = 0; refineInfoListI < refineInfoListLength; refineInfoListI++) {
			if (readByte(buf) == 0) { 
				this.refineInfoList.add(null);
			} else {
				RefineBean refineBean = new RefineBean();
				refineBean.read(buf);
				this.refineInfoList.add(refineBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, fightValue, false);
		writeShort(buf, this.refineInfoList.size());
		for (int refineInfoListI = 0; refineInfoListI < this.refineInfoList.size(); refineInfoListI++) {
			this.writeBean(buf, this.refineInfoList.get(refineInfoListI));
		}
		return true;
	}
}
