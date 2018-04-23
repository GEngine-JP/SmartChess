package com.sh.game.system.rank.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.rank.msg.bean.RankDataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>排行榜数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLookRankMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLookRankMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 26002;
	}
	
	/**
	 * 排行榜数据
	 */
	private List<RankDataBean> rankDataBean = new ArrayList<>();

	public List<RankDataBean> getRankDataBean() {
		return rankDataBean;
	}

	public void setRankDataBean(List<RankDataBean> rankDataBean) {
		this.rankDataBean = rankDataBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		int rankDataBeanLength = readShort(buf);
		for (int rankDataBeanI = 0; rankDataBeanI < rankDataBeanLength; rankDataBeanI++) {
			if (readByte(buf) == 0) { 
				this.rankDataBean.add(null);
			} else {
				RankDataBean rankDataBean = new RankDataBean();
				rankDataBean.read(buf);
				this.rankDataBean.add(rankDataBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.rankDataBean.size());
		for (int rankDataBeanI = 0; rankDataBeanI < this.rankDataBean.size(); rankDataBeanI++) {
			this.writeBean(buf, this.rankDataBean.get(rankDataBeanI));
		}
		return true;
	}
}
