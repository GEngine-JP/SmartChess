package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.robtreasure.msg.bean.LingBaoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送穿戴的灵宝信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLingBaoInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLingBaoInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50019;
	}
	
	/**
	 * 1、玩家 2、英雄
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 灵宝列表
	 */
	private List<LingBaoBean> lingBaoList = new ArrayList<>();

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

		public List<LingBaoBean> getLingBaoList() {
		return lingBaoList;
	}

	public void setLingBaoList(List<LingBaoBean> lingBaoList) {
		this.lingBaoList = lingBaoList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		int lingBaoListLength = readShort(buf);
		for (int lingBaoListI = 0; lingBaoListI < lingBaoListLength; lingBaoListI++) {
			if (readByte(buf) == 0) { 
				this.lingBaoList.add(null);
			} else {
				LingBaoBean lingBaoBean = new LingBaoBean();
				lingBaoBean.read(buf);
				this.lingBaoList.add(lingBaoBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		writeShort(buf, this.lingBaoList.size());
		for (int lingBaoListI = 0; lingBaoListI < this.lingBaoList.size(); lingBaoListI++) {
			this.writeBean(buf, this.lingBaoList.get(lingBaoListI));
		}
		return true;
	}
}
