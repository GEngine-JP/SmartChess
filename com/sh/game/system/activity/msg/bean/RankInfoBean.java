package com.sh.game.system.activity.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class RankInfoBean extends KryoBean {

	/**
	 * 排名
	 */
	private int rank;

	/**
	 * 名字
	 */
	private String roleName;

	/**
	 * 转生
	 */
	private int rein;

	/**
	 * 等级
	 */
	private int level;

	/**
	 * 参数
	 */
	private int param;


	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	public int getRein() {
		return rein;
	}

	public void setRein(int rein) {
		this.rein = rein;
	}

	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	public int getParam() {
		return param;
	}

	public void setParam(int param) {
		this.param = param;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.rank = readInt(buf, false);
		this.roleName = readString(buf);
		this.rein = readInt(buf, false);
		this.level = readInt(buf, false);
		this.param = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, rank, false);
		this.writeString(buf, roleName);
		this.writeInt(buf, rein, false);
		this.writeInt(buf, level, false);
		this.writeInt(buf, param, false);

		return true;
	}
}

