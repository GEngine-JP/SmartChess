package com.sh.game.system.vip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>vip领过的数据</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResBuyVipRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResBuyVipRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 28007;
	}
	
	/**
	 * 领过的vip等级
	 */
	private List<Integer> level = new ArrayList<Integer>();


	public List<Integer> getLevel() {
		return level;
	}

	public void setLevel(List<Integer> level) {
		this.level = level;
	}


	@Override
	public boolean read(KryoInput buf) {
		int levelLength = readShort(buf);
		for (int levelI = 0; levelI < levelLength; levelI++) {
			this.level.add(this.readInt(buf, false));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.level.size());
		for (int levelI = 0; levelI < this.level.size(); levelI++) {
			this.writeInt(buf, this.level.get(levelI), false);
		}


		return true;
	}
}

