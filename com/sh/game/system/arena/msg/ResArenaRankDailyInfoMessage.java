package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.arena.msg.bean.ArenaRankBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送每日结算排行信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResArenaRankDailyInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResArenaRankDailyInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37015;
	}
	
	/**
	 * arenaRanklist
	 */
	private List<ArenaRankBean> arenaRanklist = new ArrayList<>();

	public List<ArenaRankBean> getArenaRanklist() {
		return arenaRanklist;
	}

	public void setArenaRanklist(List<ArenaRankBean> arenaRanklist) {
		this.arenaRanklist = arenaRanklist;
	}

	@Override
	public boolean read(KryoInput buf) {

		int arenaRanklistLength = readShort(buf);
		for (int arenaRanklistI = 0; arenaRanklistI < arenaRanklistLength; arenaRanklistI++) {
			if (readByte(buf) == 0) { 
				this.arenaRanklist.add(null);
			} else {
				ArenaRankBean arenaRankBean = new ArenaRankBean();
				arenaRankBean.read(buf);
				this.arenaRanklist.add(arenaRankBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.arenaRanklist.size());
		for (int arenaRanklistI = 0; arenaRanklistI < this.arenaRanklist.size(); arenaRanklistI++) {
			this.writeBean(buf, this.arenaRanklist.get(arenaRanklistI));
		}
		return true;
	}
}
