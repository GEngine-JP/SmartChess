package com.sh.game.system.official.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class DailyTaskBean extends KryoBean {

	/**
	 * 任务id
	 */
	private int id;
	/**
	 * 已完成数量
	 */
	private int completedNum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

		public int getCompletedNum() {
		return completedNum;
	}

	public void setCompletedNum(int completedNum) {
		this.completedNum = completedNum;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.id = readInt(buf, false);
		this.completedNum = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, id, false);
		this.writeInt(buf, completedNum, false);
		return true;
	}
}
