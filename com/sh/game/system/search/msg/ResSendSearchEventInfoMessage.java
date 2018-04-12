package com.sh.game.system.search.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.search.msg.bean.SearchEventBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回探索事件信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendSearchEventInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendSearchEventInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 38002;
	}
	
	/**
	 * 事件列表
	 */
	private List<SearchEventBean> eventList = new ArrayList<SearchEventBean>();


	public List<SearchEventBean> getEventList() {
		return eventList;
	}

	public void setEventList(List<SearchEventBean> eventList) {
		this.eventList = eventList;
	}


	@Override
	public boolean read(KryoInput buf) {
		int eventListLength = readShort(buf);
		for (int eventListI = 0; eventListI < eventListLength; eventListI++) {
			if (readByte(buf) == 0) { 
				this.eventList.add(null);
			} else {
				SearchEventBean searchEventBean = new SearchEventBean();
				searchEventBean.read(buf);
				this.eventList.add(searchEventBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.eventList.size());
		for (int eventListI = 0; eventListI < this.eventList.size(); eventListI++) {
			this.writeBean(buf, this.eventList.get(eventListI));
		}


		return true;
	}
}

