package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>匹配返回</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResLadderFightMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLadderFightMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5002;
	}
	
	/**
	 * 队伍id
	 */
	private int teamId;

	/**
	 * 开始匹配的时间
	 */
	private int startTime;


	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	
	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.teamId = readInt(buf, false);
		this.startTime = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, teamId, false);
		this.writeInt(buf, startTime, false);

		return true;
	}
}

