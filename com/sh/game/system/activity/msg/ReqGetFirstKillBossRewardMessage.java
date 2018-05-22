package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求领取首杀boss奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetFirstKillBossRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetFirstKillBossRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4022;
	}
	
	/**
	 * activityId
	 */
	private int activityId;
	/**
	 * 首杀表配置id
	 */
	private int cfgId;

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

		public int getCfgId() {
		return cfgId;
	}

	public void setCfgId(int cfgId) {
		this.cfgId = cfgId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.activityId = readInt(buf, false);
		this.cfgId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, activityId, false);
		this.writeInt(buf, cfgId, false);
		return true;
	}
}
