package com.sh.game.system.duobao.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求夺五次</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqRobFiveTimesMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRobFiveTimesMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48008;
	}
	
	/**
	 * 假人id
	 */
	private int roleId;


	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.roleId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, roleId, false);

		return true;
	}
}

