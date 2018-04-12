package com.sh.game.system.achievement.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.achievement.msg.bean.AchievementBean;


/**
 * <p>成就奖励返回</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResAchievementRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAchievementRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 17002;
	}
	
	/**
	 * 成就信息
	 */
	private AchievementBean achievementBean;


	public AchievementBean getAchievementBean() {
		return achievementBean;
	}

	public void setAchievementBean(AchievementBean achievementBean) {
		this.achievementBean = achievementBean;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		if (readByte(buf) != 0) {
			AchievementBean achievementBean = new AchievementBean();
			achievementBean.read(buf);
			this.achievementBean = achievementBean;
		}

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeBean(buf, achievementBean);

		return true;
	}
}

