package com.sh.game.system.boss.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class BossKillerBean extends KryoBean {

	/**
	 * 击杀时间
	 */
	private int killTime;

	/**
	 * 击杀者名字
	 */
	private String killerName;

	/**
	 * 击杀者战斗力
	 */
	private int killerPower;


	public int getKillTime() {
		return killTime;
	}

	public void setKillTime(int killTime) {
		this.killTime = killTime;
	}

	
	public String getKillerName() {
		return killerName;
	}

	public void setKillerName(String killerName) {
		this.killerName = killerName;
	}

	
	public int getKillerPower() {
		return killerPower;
	}

	public void setKillerPower(int killerPower) {
		this.killerPower = killerPower;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.killTime = readInt(buf, false);
		this.killerName = readString(buf);
		this.killerPower = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, killTime, false);
		this.writeString(buf, killerName);
		this.writeInt(buf, killerPower, false);

		return true;
	}
}

