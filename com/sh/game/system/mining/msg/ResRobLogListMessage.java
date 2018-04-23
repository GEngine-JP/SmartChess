package com.sh.game.system.mining.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送抢夺日志列表信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRobLogListMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRobLogListMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48011;
	}
	
	/**
	 * 抢夺日志列表
	 */
	private List<String> logList = new ArrayList<>();

	public List<String> getLogList() {
		return logList;
	}

	public void setLogList(List<String> logList) {
		this.logList = logList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int logListLength = readShort(buf);
		for (int logListI = 0; logListI < logListLength; logListI++) {
			this.logList.add(this.readString(buf));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.logList.size());
		for (int logListI = 0; logListI < this.logList.size(); logListI++) {
			this.writeString(buf, this.logList.get(logListI));
		}
		return true;
	}
}
