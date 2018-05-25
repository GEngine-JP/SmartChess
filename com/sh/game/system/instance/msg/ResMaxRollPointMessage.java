package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回roll点结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResMaxRollPointMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResMaxRollPointMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20036;
	}
	
	/**
	 * 最大点数
	 */
	private int maxCount;
	/**
	 * 玩家名字
	 */
	private String roleName;

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

		public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.maxCount = readInt(buf, false);
		this.roleName = readString(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, maxCount, false);
		this.writeString(buf, roleName);
		return true;
	}
}
