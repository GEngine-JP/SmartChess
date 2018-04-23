package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.shobak.msg.bean.LastSiegeRankInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回上届攻城排行信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendLastSiegeRankInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendLastSiegeRankInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40002;
	}
	
	/**
	 * 排行信息
	 */
	private List<LastSiegeRankInfo> rankInfos = new ArrayList<>();
	/**
	 * 面板类型1为工会排行2个人排行
	 */
	private int type;
	/**
	 * 上届霸主行会
	 */
	private String shoBakUnion;

	public List<LastSiegeRankInfo> getRankInfos() {
		return rankInfos;
	}

	public void setRankInfos(List<LastSiegeRankInfo> rankInfos) {
		this.rankInfos = rankInfos;
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public String getShoBakUnion() {
		return shoBakUnion;
	}

	public void setShoBakUnion(String shoBakUnion) {
		this.shoBakUnion = shoBakUnion;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int rankInfosLength = readShort(buf);
		for (int rankInfosI = 0; rankInfosI < rankInfosLength; rankInfosI++) {
			if (readByte(buf) == 0) { 
				this.rankInfos.add(null);
			} else {
				LastSiegeRankInfo lastSiegeRankInfo = new LastSiegeRankInfo();
				lastSiegeRankInfo.read(buf);
				this.rankInfos.add(lastSiegeRankInfo);
			}
		}		this.type = readInt(buf, false);
		this.shoBakUnion = readString(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.rankInfos.size());
		for (int rankInfosI = 0; rankInfosI < this.rankInfos.size(); rankInfosI++) {
			this.writeBean(buf, this.rankInfos.get(rankInfosI));
		}		this.writeInt(buf, type, false);
		this.writeString(buf, shoBakUnion);
		return true;
	}
}
