package com.sh.game.system.user.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>随机名字</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRandomNameMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRandomNameMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 1005;
	}
	
	/**
	 * 角色名字
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
