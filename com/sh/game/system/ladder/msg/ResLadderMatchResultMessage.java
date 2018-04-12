package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回匹配结果</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResLadderMatchResultMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLadderMatchResultMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5019;
	}
	
	/**
	 * 队伍id
	 */
	private int teamId;

	/**
	 * 目标名字
	 */
	private String targetName;

	/**
	 * 目标职业
	 */
	private int targetCareer;

	/**
	 * 目标性别
	 */
	private int targetSex;

	/**
	 * 目标段位
	 */
	private int targetRank;

	/**
	 * 目标星数
	 */
	private int targetStar;


	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	
	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	
	public int getTargetCareer() {
		return targetCareer;
	}

	public void setTargetCareer(int targetCareer) {
		this.targetCareer = targetCareer;
	}

	
	public int getTargetSex() {
		return targetSex;
	}

	public void setTargetSex(int targetSex) {
		this.targetSex = targetSex;
	}

	
	public int getTargetRank() {
		return targetRank;
	}

	public void setTargetRank(int targetRank) {
		this.targetRank = targetRank;
	}

	
	public int getTargetStar() {
		return targetStar;
	}

	public void setTargetStar(int targetStar) {
		this.targetStar = targetStar;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.teamId = readInt(buf, false);
		this.targetName = readString(buf);
		this.targetCareer = readInt(buf, false);
		this.targetSex = readInt(buf, false);
		this.targetRank = readInt(buf, false);
		this.targetStar = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, teamId, false);
		this.writeString(buf, targetName);
		this.writeInt(buf, targetCareer, false);
		this.writeInt(buf, targetSex, false);
		this.writeInt(buf, targetRank, false);
		this.writeInt(buf, targetStar, false);

		return true;
	}
}

