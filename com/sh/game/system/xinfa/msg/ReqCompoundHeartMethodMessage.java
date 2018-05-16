package com.sh.game.system.xinfa.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>请求合成心法</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqCompoundHeartMethodMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqCompoundHeartMethodMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 58006;
	}
	
	/**
	 * 要合成的配置表id
	 */
	private int cfgId;
	/**
	 * 选择消耗的心法id
	 */
	private List<Integer> methodId = new ArrayList<>();

	public int getCfgId() {
		return cfgId;
	}

	public void setCfgId(int cfgId) {
		this.cfgId = cfgId;
	}

		public List<Integer> getMethodId() {
		return methodId;
	}

	public void setMethodId(List<Integer> methodId) {
		this.methodId = methodId;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.cfgId = readInt(buf, false);
		int methodIdLength = readShort(buf);
		for (int methodIdI = 0; methodIdI < methodIdLength; methodIdI++) {
			this.methodId.add(this.readInt(buf, false));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, cfgId, false);
		writeShort(buf, this.methodId.size());
		for (int methodIdI = 0; methodIdI < this.methodId.size(); methodIdI++) {
			this.writeInt(buf, this.methodId.get(methodIdI), false);
		}
		return true;
	}
}
