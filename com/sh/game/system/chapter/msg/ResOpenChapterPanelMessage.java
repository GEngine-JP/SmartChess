package com.sh.game.system.chapter.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.chapter.msg.bean.ChapterRankBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回关卡排行面板</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResOpenChapterPanelMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOpenChapterPanelMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 41006;
	}
	
	/**
	 * 关卡排行列表
	 */
	private List<ChapterRankBean> chapterRankBean = new ArrayList<ChapterRankBean>();


	public List<ChapterRankBean> getChapterRankBean() {
		return chapterRankBean;
	}

	public void setChapterRankBean(List<ChapterRankBean> chapterRankBean) {
		this.chapterRankBean = chapterRankBean;
	}


	@Override
	public boolean read(KryoInput buf) {
		int chapterRankBeanLength = readShort(buf);
		for (int chapterRankBeanI = 0; chapterRankBeanI < chapterRankBeanLength; chapterRankBeanI++) {
			if (readByte(buf) == 0) { 
				this.chapterRankBean.add(null);
			} else {
				ChapterRankBean chapterRankBean = new ChapterRankBean();
				chapterRankBean.read(buf);
				this.chapterRankBean.add(chapterRankBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.chapterRankBean.size());
		for (int chapterRankBeanI = 0; chapterRankBeanI < this.chapterRankBean.size(); chapterRankBeanI++) {
			this.writeBean(buf, this.chapterRankBean.get(chapterRankBeanI));
		}


		return true;
	}
}

