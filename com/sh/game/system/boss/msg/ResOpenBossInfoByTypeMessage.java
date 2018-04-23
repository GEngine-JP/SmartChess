package com.sh.game.system.boss.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.boss.msg.bean.BossInfo;
import com.sh.game.system.boss.msg.bean.InstanceInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>BOSS面板信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResOpenBossInfoByTypeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOpenBossInfoByTypeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 30002;
	}
	
	/**
	 * boss列表信息
	 */
	private List<BossInfo> bossInfo = new ArrayList<>();
	/**
	 * 副本信息
	 */
	private InstanceInfo instanceInfo;

	public List<BossInfo> getBossInfo() {
		return bossInfo;
	}

	public void setBossInfo(List<BossInfo> bossInfo) {
		this.bossInfo = bossInfo;
	}
	public InstanceInfo getInstanceInfo() {
		return instanceInfo;
	}

	public void setInstanceInfo(InstanceInfo instanceInfo) {
		this.instanceInfo = instanceInfo;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int bossInfoLength = readShort(buf);
		for (int bossInfoI = 0; bossInfoI < bossInfoLength; bossInfoI++) {
			if (readByte(buf) == 0) { 
				this.bossInfo.add(null);
			} else {
				BossInfo bossInfo = new BossInfo();
				bossInfo.read(buf);
				this.bossInfo.add(bossInfo);
			}
		}		if (readByte(buf) != 0) {
			InstanceInfo instanceInfo = new InstanceInfo();
			instanceInfo.read(buf);
			this.instanceInfo = instanceInfo;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.bossInfo.size());
		for (int bossInfoI = 0; bossInfoI < this.bossInfo.size(); bossInfoI++) {
			this.writeBean(buf, this.bossInfo.get(bossInfoI));
		}		this.writeBean(buf, instanceInfo);
		return true;
	}
}
