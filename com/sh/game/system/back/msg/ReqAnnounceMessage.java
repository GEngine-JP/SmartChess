package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>请求发送公告(后台用)</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqAnnounceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqAnnounceMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43008;
	}
	
	/**
	 * 公告id
	 */
	private int announceId;
	/**
	 * 参数列表
	 */
	private List<String> params = new ArrayList<>();

	public int getAnnounceId() {
		return announceId;
	}

	public void setAnnounceId(int announceId) {
		this.announceId = announceId;
	}

		public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.announceId = readInt(buf, false);
		int paramsLength = readShort(buf);
		for (int paramsI = 0; paramsI < paramsLength; paramsI++) {
			this.params.add(this.readString(buf));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, announceId, false);
		writeShort(buf, this.params.size());
		for (int paramsI = 0; paramsI < this.params.size(); paramsI++) {
			this.writeString(buf, this.params.get(paramsI));
		}
		return true;
	}
}
