package com.sh.game.system.bag.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class LingBaoBean extends KryoBean {

	/**
	 * 等级
	 */
	private int level;

	/**
	 * 当前经验
	 */
	private int nowExp;

	/**
	 * 总经验
	 */
	private int totalExp;

	/**
	 * 精炼阶数
	 */
	private int refineLv;

	/**
	 * 灵宝战力
	 */
	private int power;


	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	public int getNowExp() {
		return nowExp;
	}

	public void setNowExp(int nowExp) {
		this.nowExp = nowExp;
	}

	
	public int getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}

	
	public int getRefineLv() {
		return refineLv;
	}

	public void setRefineLv(int refineLv) {
		this.refineLv = refineLv;
	}

	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.level = readInt(buf, false);
		this.nowExp = readInt(buf, false);
		this.totalExp = readInt(buf, false);
		this.refineLv = readInt(buf, false);
		this.power = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, level, false);
		this.writeInt(buf, nowExp, false);
		this.writeInt(buf, totalExp, false);
		this.writeInt(buf, refineLv, false);
		this.writeInt(buf, power, false);

		return true;
	}
}

