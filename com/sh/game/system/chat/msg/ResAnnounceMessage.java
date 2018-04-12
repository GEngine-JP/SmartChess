package com.sh.game.system.chat.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>公告消息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResAnnounceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAnnounceMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 6008;
	}
	
	/**
	 * 参数列表
	 */
	private List<String> params = new ArrayList<String>();


	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}


	@Override
	public boolean read(KryoInput buf) {
		int paramsLength = readShort(buf);
		for (int paramsI = 0; paramsI < paramsLength; paramsI++) {
			this.params.add(this.readString(buf));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.params.size());
		for (int paramsI = 0; paramsI < this.params.size(); paramsI++) {
			this.writeString(buf, this.params.get(paramsI));
		}


		return true;
	}
}

