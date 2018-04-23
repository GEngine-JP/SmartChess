package com.sh.game.system.chapter.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.chapter.msg.bean.ChapterItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回每波的奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResGetRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResGetRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 41004;
	}
	
	/**
	 * 副本奖励
	 */
	private List<ChapterItemBean> itemBean = new ArrayList<>();

	public List<ChapterItemBean> getItemBean() {
		return itemBean;
	}

	public void setItemBean(List<ChapterItemBean> itemBean) {
		this.itemBean = itemBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		int itemBeanLength = readShort(buf);
		for (int itemBeanI = 0; itemBeanI < itemBeanLength; itemBeanI++) {
			if (readByte(buf) == 0) { 
				this.itemBean.add(null);
			} else {
				ChapterItemBean chapterItemBean = new ChapterItemBean();
				chapterItemBean.read(buf);
				this.itemBean.add(chapterItemBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.itemBean.size());
		for (int itemBeanI = 0; itemBeanI < this.itemBean.size(); itemBeanI++) {
			this.writeBean(buf, this.itemBean.get(itemBeanI));
		}
		return true;
	}
}
