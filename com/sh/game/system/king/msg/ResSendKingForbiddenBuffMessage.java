package com.sh.game.system.king.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送随机到的buff</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendKingForbiddenBuffMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendKingForbiddenBuffMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 45007;
	}
	
	/**
	 * 本关随机到的buffId
	 */
	private List<Integer> buffIds = new ArrayList<Integer>();


	public List<Integer> getBuffIds() {
		return buffIds;
	}

	public void setBuffIds(List<Integer> buffIds) {
		this.buffIds = buffIds;
	}


	@Override
	public boolean read(KryoInput buf) {
		int buffIdsLength = readShort(buf);
		for (int buffIdsI = 0; buffIdsI < buffIdsLength; buffIdsI++) {
			this.buffIds.add(this.readInt(buf, false));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.buffIds.size());
		for (int buffIdsI = 0; buffIdsI < this.buffIds.size(); buffIdsI++) {
			this.writeInt(buf, this.buffIds.get(buffIdsI), false);
		}


		return true;
	}
}

