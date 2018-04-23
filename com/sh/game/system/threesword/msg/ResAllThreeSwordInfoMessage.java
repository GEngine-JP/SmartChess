package com.sh.game.system.threesword.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.threesword.msg.bean.ThreeSwordBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回所有三才装备信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResAllThreeSwordInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAllThreeSwordInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 46001;
	}
	
	/**
	 * 三才装备列表
	 */
	private List<ThreeSwordBean> threeSwordList = new ArrayList<>();

	public List<ThreeSwordBean> getThreeSwordList() {
		return threeSwordList;
	}

	public void setThreeSwordList(List<ThreeSwordBean> threeSwordList) {
		this.threeSwordList = threeSwordList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int threeSwordListLength = readShort(buf);
		for (int threeSwordListI = 0; threeSwordListI < threeSwordListLength; threeSwordListI++) {
			if (readByte(buf) == 0) { 
				this.threeSwordList.add(null);
			} else {
				ThreeSwordBean threeSwordBean = new ThreeSwordBean();
				threeSwordBean.read(buf);
				this.threeSwordList.add(threeSwordBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.threeSwordList.size());
		for (int threeSwordListI = 0; threeSwordListI < this.threeSwordList.size(); threeSwordListI++) {
			this.writeBean(buf, this.threeSwordList.get(threeSwordListI));
		}
		return true;
	}
}
