package com.sh.game.system.search.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.search.msg.bean.SearchEventBean;

/**
 * <p>返回探索事件变化</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendSearchEventChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendSearchEventChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 38006;
	}
	
	/**
	 * 变化的探索事件
	 */
	private SearchEventBean eventBean;
	/**
	 * 事件变化状态 1删除 2增加
	 */
	private int state;

	public SearchEventBean getEventBean() {
		return eventBean;
	}

	public void setEventBean(SearchEventBean eventBean) {
		this.eventBean = eventBean;
	}

		public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			SearchEventBean searchEventBean = new SearchEventBean();
			searchEventBean.read(buf);
			this.eventBean = searchEventBean;
		}
		this.state = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, eventBean);
		this.writeInt(buf, state, false);
		return true;
	}
}
