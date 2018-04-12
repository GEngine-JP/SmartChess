package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.shobak.msg.bean.LastSiegeRankInfo;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>沙巴克行会排名结算显示面板</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendShobakResultRankInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendShobakResultRankInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40020;
	}
	
	/**
	 * 排名信息
	 */
	private List<LastSiegeRankInfo> infos = new ArrayList<LastSiegeRankInfo>();

	/**
	 * 结果 胜利1或失败0
	 */
	private int result;


	public List<LastSiegeRankInfo> getInfos() {
		return infos;
	}

	public void setInfos(List<LastSiegeRankInfo> infos) {
		this.infos = infos;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		int infosLength = readShort(buf);
		for (int infosI = 0; infosI < infosLength; infosI++) {
			if (readByte(buf) == 0) { 
				this.infos.add(null);
			} else {
				LastSiegeRankInfo lastSiegeRankInfo = new LastSiegeRankInfo();
				lastSiegeRankInfo.read(buf);
				this.infos.add(lastSiegeRankInfo);
			}
		}

		this.result = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.infos.size());
		for (int infosI = 0; infosI < this.infos.size(); infosI++) {
			this.writeBean(buf, this.infos.get(infosI));
		}

		this.writeInt(buf, result, false);

		return true;
	}
}

