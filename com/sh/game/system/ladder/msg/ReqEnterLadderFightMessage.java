package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求进入天梯战斗</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqEnterLadderFightMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqEnterLadderFightMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5018;
	}
	
	/**
	 * 队伍id
	 */
	private int teamId;


	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.teamId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, teamId, false);

		return true;
	}
}

