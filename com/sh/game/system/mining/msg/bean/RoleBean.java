package com.sh.game.system.mining.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class RoleBean extends KryoBean {

	/**
	 * 玩家id
	 */
	private long roleId;

	/**
	 * 玩家名字
	 */
	private String roleName;


	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.roleId = readLong(buf);
		this.roleName = readString(buf);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, roleId);
		this.writeString(buf, roleName);

		return true;
	}
}

