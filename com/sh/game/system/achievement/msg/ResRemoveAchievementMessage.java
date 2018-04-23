package com.sh.game.system.achievement.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>移除成就</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRemoveAchievementMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRemoveAchievementMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 17008;
	}
	
	/**
	 * 成就id
	 */
	private int achievementId;

	public int getAchievementId() {
		return achievementId;
	}

	public void setAchievementId(int achievementId) {
		this.achievementId = achievementId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.achievementId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, achievementId, false);
		return true;
	}
}
