package com.sh.game.system.runes.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.runes.msg.bean.RuneSuitBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>符文套装消息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRunesSuitMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRunesSuitMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 24004;
	}
	
	/**
	 * 套装列表
	 */
	private List<RuneSuitBean> runeSuitList = new ArrayList<>();

	public List<RuneSuitBean> getRuneSuitList() {
		return runeSuitList;
	}

	public void setRuneSuitList(List<RuneSuitBean> runeSuitList) {
		this.runeSuitList = runeSuitList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int runeSuitListLength = readShort(buf);
		for (int runeSuitListI = 0; runeSuitListI < runeSuitListLength; runeSuitListI++) {
			if (readByte(buf) == 0) { 
				this.runeSuitList.add(null);
			} else {
				RuneSuitBean runeSuitBean = new RuneSuitBean();
				runeSuitBean.read(buf);
				this.runeSuitList.add(runeSuitBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.runeSuitList.size());
		for (int runeSuitListI = 0; runeSuitListI < this.runeSuitList.size(); runeSuitListI++) {
			this.writeBean(buf, this.runeSuitList.get(runeSuitListI));
		}
		return true;
	}
}
