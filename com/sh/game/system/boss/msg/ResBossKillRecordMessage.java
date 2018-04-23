package com.sh.game.system.boss.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.boss.msg.bean.BossKillerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回BOSS击杀记录</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResBossKillRecordMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResBossKillRecordMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 30005;
	}
	
	/**
	 * 副本id
	 */
	private int instanceId;
	/**
	 * 击杀记录
	 */
	private List<BossKillerBean> bossKillerList = new ArrayList<>();

	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

		public List<BossKillerBean> getBossKillerList() {
		return bossKillerList;
	}

	public void setBossKillerList(List<BossKillerBean> bossKillerList) {
		this.bossKillerList = bossKillerList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.instanceId = readInt(buf, false);
		int bossKillerListLength = readShort(buf);
		for (int bossKillerListI = 0; bossKillerListI < bossKillerListLength; bossKillerListI++) {
			if (readByte(buf) == 0) { 
				this.bossKillerList.add(null);
			} else {
				BossKillerBean bossKillerBean = new BossKillerBean();
				bossKillerBean.read(buf);
				this.bossKillerList.add(bossKillerBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, instanceId, false);
		writeShort(buf, this.bossKillerList.size());
		for (int bossKillerListI = 0; bossKillerListI < this.bossKillerList.size(); bossKillerListI++) {
			this.writeBean(buf, this.bossKillerList.get(bossKillerListI));
		}
		return true;
	}
}
