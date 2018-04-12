package com.sh.game.system.ladder.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class LadderRankBean extends KryoBean {

	/**
	 * 角色id
	 */
	private long roleId;

	/**
	 * 排名
	 */
	private int rank;

	/**
	 * 玩家名
	 */
	private String name;

	/**
	 * 段位名字
	 */
	private String rankName;

	/**
	 * 积分
	 */
	private int point;

	/**
	 * 配置表id
	 */
	private int rankId;

	/**
	 * 星数
	 */
	private int star;


	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	
	public int getRankId() {
		return rankId;
	}

	public void setRankId(int rankId) {
		this.rankId = rankId;
	}

	
	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.roleId = readLong(buf);
		this.rank = readInt(buf, false);
		this.name = readString(buf);
		this.rankName = readString(buf);
		this.point = readInt(buf, false);
		this.rankId = readInt(buf, false);
		this.star = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, roleId);
		this.writeInt(buf, rank, false);
		this.writeString(buf, name);
		this.writeString(buf, rankName);
		this.writeInt(buf, point, false);
		this.writeInt(buf, rankId, false);
		this.writeInt(buf, star, false);

		return true;
	}
}

