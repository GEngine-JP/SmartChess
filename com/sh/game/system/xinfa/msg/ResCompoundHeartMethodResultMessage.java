package com.sh.game.system.xinfa.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送合成心法结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResCompoundHeartMethodResultMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCompoundHeartMethodResultMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 58007;
	}
	
	/**
	 * 合成后的心法id
	 */
	private List<Integer> methodId = new ArrayList<>();

	public List<Integer> getMethodId() {
		return methodId;
	}

	public void setMethodId(List<Integer> methodId) {
		this.methodId = methodId;
	}

	@Override
	public boolean read(KryoInput buf) {

		int methodIdLength = readShort(buf);
		for (int methodIdI = 0; methodIdI < methodIdLength; methodIdI++) {
			this.methodId.add(this.readInt(buf, false));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.methodId.size());
		for (int methodIdI = 0; methodIdI < this.methodId.size(); methodIdI++) {
			this.writeInt(buf, this.methodId.get(methodIdI), false);
		}
		return true;
	}
}
