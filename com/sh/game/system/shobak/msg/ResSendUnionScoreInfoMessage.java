package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.shobak.msg.bean.UnionScorePanelInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送行会积分面板信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendUnionScoreInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendUnionScoreInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40010;
	}
	
	/**
	 * 行会排名信息
	 */
	private List<UnionScorePanelInfo> unionInfos = new ArrayList<>();

	public List<UnionScorePanelInfo> getUnionInfos() {
		return unionInfos;
	}

	public void setUnionInfos(List<UnionScorePanelInfo> unionInfos) {
		this.unionInfos = unionInfos;
	}

	@Override
	public boolean read(KryoInput buf) {

		int unionInfosLength = readShort(buf);
		for (int unionInfosI = 0; unionInfosI < unionInfosLength; unionInfosI++) {
			if (readByte(buf) == 0) { 
				this.unionInfos.add(null);
			} else {
				UnionScorePanelInfo unionScorePanelInfo = new UnionScorePanelInfo();
				unionScorePanelInfo.read(buf);
				this.unionInfos.add(unionScorePanelInfo);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.unionInfos.size());
		for (int unionInfosI = 0; unionInfosI < this.unionInfos.size(); unionInfosI++) {
			this.writeBean(buf, this.unionInfos.get(unionInfosI));
		}
		return true;
	}
}
