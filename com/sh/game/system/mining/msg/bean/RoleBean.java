package com.sh.game.system.mining.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
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
	/**
	 * 排序
	 */
	private int index;

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

		public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.roleId = readLong(buf);
		this.roleName = readString(buf);
		this.index = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, roleId);
		this.writeString(buf, roleName);
		this.writeInt(buf, index, false);
		return true;
	}
}
