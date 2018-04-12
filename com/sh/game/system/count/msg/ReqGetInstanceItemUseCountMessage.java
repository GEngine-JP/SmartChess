package com.sh.game.system.count.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>请求副本道具使用次数</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetInstanceItemUseCountMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetInstanceItemUseCountMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 21003;
	}
	
	/**
	 * 副本唯一id
	 */
	private int uniqueId;

	/**
	 * global配置id
	 */
	private List<Integer> globalId = new ArrayList<Integer>();


	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	
	public List<Integer> getGlobalId() {
		return globalId;
	}

	public void setGlobalId(List<Integer> globalId) {
		this.globalId = globalId;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.uniqueId = readInt(buf, false);
		int globalIdLength = readShort(buf);
		for (int globalIdI = 0; globalIdI < globalIdLength; globalIdI++) {
			this.globalId.add(this.readInt(buf, false));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, uniqueId, false);
		writeShort(buf, this.globalId.size());
		for (int globalIdI = 0; globalIdI < this.globalId.size(); globalIdI++) {
			this.writeInt(buf, this.globalId.get(globalIdI), false);
		}


		return true;
	}
}

