package com.sh.game.system.rank.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.rank.msg.bean.RankRoleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>排行榜玩家详细数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLookRankRoleInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLookRankRoleInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 26004;
	}
	
	/**
	 * 排行榜玩家详细数据
	 */
	private List<RankRoleBean> rankRoleBean = new ArrayList<>();

	public List<RankRoleBean> getRankRoleBean() {
		return rankRoleBean;
	}

	public void setRankRoleBean(List<RankRoleBean> rankRoleBean) {
		this.rankRoleBean = rankRoleBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		int rankRoleBeanLength = readShort(buf);
		for (int rankRoleBeanI = 0; rankRoleBeanI < rankRoleBeanLength; rankRoleBeanI++) {
			if (readByte(buf) == 0) { 
				this.rankRoleBean.add(null);
			} else {
				RankRoleBean rankRoleBean = new RankRoleBean();
				rankRoleBean.read(buf);
				this.rankRoleBean.add(rankRoleBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.rankRoleBean.size());
		for (int rankRoleBeanI = 0; rankRoleBeanI < this.rankRoleBean.size(); rankRoleBeanI++) {
			this.writeBean(buf, this.rankRoleBean.get(rankRoleBeanI));
		}
		return true;
	}
}
