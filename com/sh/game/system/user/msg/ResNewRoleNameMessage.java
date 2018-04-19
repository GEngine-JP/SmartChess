package com.sh.game.system.user.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回玩家名称</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResNewRoleNameMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResNewRoleNameMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 1013;
	}
	
	/**
	 * 玩家名称
	 */
	private String roleName;


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.roleName = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, roleName);

		return true;
	}
}

