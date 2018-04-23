package com.sh.game.system.title.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.title.msg.bean.TitleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>称号列表</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResTitleListMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResTitleListMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 33005;
	}
	
	/**
	 * 称号列表
	 */
	private List<TitleBean> titleBeanList = new ArrayList<>();

	public List<TitleBean> getTitleBeanList() {
		return titleBeanList;
	}

	public void setTitleBeanList(List<TitleBean> titleBeanList) {
		this.titleBeanList = titleBeanList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int titleBeanListLength = readShort(buf);
		for (int titleBeanListI = 0; titleBeanListI < titleBeanListLength; titleBeanListI++) {
			if (readByte(buf) == 0) { 
				this.titleBeanList.add(null);
			} else {
				TitleBean titleBean = new TitleBean();
				titleBean.read(buf);
				this.titleBeanList.add(titleBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.titleBeanList.size());
		for (int titleBeanListI = 0; titleBeanListI < this.titleBeanList.size(); titleBeanListI++) {
			this.writeBean(buf, this.titleBeanList.get(titleBeanListI));
		}
		return true;
	}
}
