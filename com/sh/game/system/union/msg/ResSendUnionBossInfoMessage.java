package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.union.msg.bean.UnionBossInfo;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送帮会BOSS信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendUnionBossInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendUnionBossInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23028;
	}
	
	/**
	 * boss信息
	 */
	private List<UnionBossInfo> bossInfo = new ArrayList<UnionBossInfo>();

	/**
	 * 已召唤boss次数
	 */
	private int callNum;

	/**
	 * 协助剩余次数
	 */
	private int aidNum;


	public List<UnionBossInfo> getBossInfo() {
		return bossInfo;
	}

	public void setBossInfo(List<UnionBossInfo> bossInfo) {
		this.bossInfo = bossInfo;
	}

	public int getCallNum() {
		return callNum;
	}

	public void setCallNum(int callNum) {
		this.callNum = callNum;
	}

	
	public int getAidNum() {
		return aidNum;
	}

	public void setAidNum(int aidNum) {
		this.aidNum = aidNum;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		int bossInfoLength = readShort(buf);
		for (int bossInfoI = 0; bossInfoI < bossInfoLength; bossInfoI++) {
			if (readByte(buf) == 0) { 
				this.bossInfo.add(null);
			} else {
				UnionBossInfo unionBossInfo = new UnionBossInfo();
				unionBossInfo.read(buf);
				this.bossInfo.add(unionBossInfo);
			}
		}

		this.callNum = readInt(buf, false);
		this.aidNum = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.bossInfo.size());
		for (int bossInfoI = 0; bossInfoI < this.bossInfo.size(); bossInfoI++) {
			this.writeBean(buf, this.bossInfo.get(bossInfoI));
		}

		this.writeInt(buf, callNum, false);
		this.writeInt(buf, aidNum, false);

		return true;
	}
}

