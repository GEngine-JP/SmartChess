package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回段位信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResLadderInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLadderInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5006;
	}
	
	/**
	 * 配置表id
	 */
	private int rankId;

	/**
	 * 段位名字
	 */
	private String rankName;

	/**
	 * 排名
	 */
	private int rank;

	/**
	 * 积分
	 */
	private int point;

	/**
	 * 星数
	 */
	private int star;

	/**
	 * 剩余次数
	 */
	private int leftCount;


	public int getRankId() {
		return rankId;
	}

	public void setRankId(int rankId) {
		this.rankId = rankId;
	}

	
	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	
	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	
	public int getLeftCount() {
		return leftCount;
	}

	public void setLeftCount(int leftCount) {
		this.leftCount = leftCount;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.rankId = readInt(buf, false);
		this.rankName = readString(buf);
		this.rank = readInt(buf, false);
		this.point = readInt(buf, false);
		this.star = readInt(buf, false);
		this.leftCount = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, rankId, false);
		this.writeString(buf, rankName);
		this.writeInt(buf, rank, false);
		this.writeInt(buf, point, false);
		this.writeInt(buf, star, false);
		this.writeInt(buf, leftCount, false);

		return true;
	}
}

