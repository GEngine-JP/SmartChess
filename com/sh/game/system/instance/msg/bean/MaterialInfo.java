package com.sh.game.system.instance.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class MaterialInfo extends KryoBean {

	/**
	 * 当前击杀波数
	 */
	private int instanceId;
	/**
	 * 剩余挑战次数
	 */
	private int remainNum;
	/**
	 * 剩余扫荡次数
	 */
	private int remainSweepNum;
	/**
	 * 副本所在组
	 */
	private int groupId;

	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

		public int getRemainNum() {
		return remainNum;
	}

	public void setRemainNum(int remainNum) {
		this.remainNum = remainNum;
	}

		public int getRemainSweepNum() {
		return remainSweepNum;
	}

	public void setRemainSweepNum(int remainSweepNum) {
		this.remainSweepNum = remainSweepNum;
	}

		public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.instanceId = readInt(buf, false);
		this.remainNum = readInt(buf, false);
		this.remainSweepNum = readInt(buf, false);
		this.groupId = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, instanceId, false);
		this.writeInt(buf, remainNum, false);
		this.writeInt(buf, remainSweepNum, false);
		this.writeInt(buf, groupId, false);
		return true;
	}
}
