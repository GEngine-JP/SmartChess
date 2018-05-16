package com.sh.game.system.rank.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.rank.msg.bean.BackRankDataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回后台排行榜数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResBackLookRankMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResBackLookRankMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 26005;
	}
	
	/**
	 * 后台排行榜数据
	 */
	private List<BackRankDataBean> backRankDataBean = new ArrayList<>();

	public List<BackRankDataBean> getBackRankDataBean() {
		return backRankDataBean;
	}

	public void setBackRankDataBean(List<BackRankDataBean> backRankDataBean) {
		this.backRankDataBean = backRankDataBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		int backRankDataBeanLength = readShort(buf);
		for (int backRankDataBeanI = 0; backRankDataBeanI < backRankDataBeanLength; backRankDataBeanI++) {
			if (readByte(buf) == 0) { 
				this.backRankDataBean.add(null);
			} else {
				BackRankDataBean backRankDataBean = new BackRankDataBean();
				backRankDataBean.read(buf);
				this.backRankDataBean.add(backRankDataBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.backRankDataBean.size());
		for (int backRankDataBeanI = 0; backRankDataBeanI < this.backRankDataBean.size(); backRankDataBeanI++) {
			this.writeBean(buf, this.backRankDataBean.get(backRankDataBeanI));
		}
		return true;
	}
}
