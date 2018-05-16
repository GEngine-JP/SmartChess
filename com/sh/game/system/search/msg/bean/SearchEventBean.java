package com.sh.game.system.search.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class SearchEventBean extends KryoBean {

	/**
	 * 事件的位置
	 */
	private int index;
	/**
	 * 事件的id
	 */
	private int eventId;
	/**
	 * 假人的信息
	 */
	private SearchTeamInfoBean fakeTeamInfo;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

		public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

		public SearchTeamInfoBean getFakeTeamInfo() {
		return fakeTeamInfo;
	}

	public void setFakeTeamInfo(SearchTeamInfoBean fakeTeamInfo) {
		this.fakeTeamInfo = fakeTeamInfo;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.index = readInt(buf, false);
		this.eventId = readInt(buf, false);
		if (readByte(buf) != 0) {
			SearchTeamInfoBean searchTeamInfoBean = new SearchTeamInfoBean();
			searchTeamInfoBean.read(buf);
			this.fakeTeamInfo = searchTeamInfoBean;
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, index, false);
		this.writeInt(buf, eventId, false);
		this.writeBean(buf, fakeTeamInfo);
		return true;
	}
}
