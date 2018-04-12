package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回烧猪显示信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendFirePigInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendFirePigInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20018;
	}
	
	/**
	 * 当前波数
	 */
	private int nowWave;

	/**
	 * 当前获得总经验
	 */
	private int nowTotalExp;

	/**
	 * 累计击杀怪物
	 */
	private int totalKill;


	public int getNowWave() {
		return nowWave;
	}

	public void setNowWave(int nowWave) {
		this.nowWave = nowWave;
	}

	
	public int getNowTotalExp() {
		return nowTotalExp;
	}

	public void setNowTotalExp(int nowTotalExp) {
		this.nowTotalExp = nowTotalExp;
	}

	
	public int getTotalKill() {
		return totalKill;
	}

	public void setTotalKill(int totalKill) {
		this.totalKill = totalKill;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.nowWave = readInt(buf, false);
		this.nowTotalExp = readInt(buf, false);
		this.totalKill = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, nowWave, false);
		this.writeInt(buf, nowTotalExp, false);
		this.writeInt(buf, totalKill, false);

		return true;
	}
}

