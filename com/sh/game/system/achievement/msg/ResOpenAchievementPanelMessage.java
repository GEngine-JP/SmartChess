package com.sh.game.system.achievement.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.achievement.msg.bean.AchievementBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回成就信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResOpenAchievementPanelMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOpenAchievementPanelMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 17004;
	}
	
	/**
	 * 成就列表
	 */
	private List<AchievementBean> achievementBean = new ArrayList<AchievementBean>();


	public List<AchievementBean> getAchievementBean() {
		return achievementBean;
	}

	public void setAchievementBean(List<AchievementBean> achievementBean) {
		this.achievementBean = achievementBean;
	}


	@Override
	public boolean read(KryoInput buf) {
		int achievementBeanLength = readShort(buf);
		for (int achievementBeanI = 0; achievementBeanI < achievementBeanLength; achievementBeanI++) {
			if (readByte(buf) == 0) { 
				this.achievementBean.add(null);
			} else {
				AchievementBean achievementBean = new AchievementBean();
				achievementBean.read(buf);
				this.achievementBean.add(achievementBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.achievementBean.size());
		for (int achievementBeanI = 0; achievementBeanI < this.achievementBean.size(); achievementBeanI++) {
			this.writeBean(buf, this.achievementBean.get(achievementBeanI));
		}


		return true;
	}
}

