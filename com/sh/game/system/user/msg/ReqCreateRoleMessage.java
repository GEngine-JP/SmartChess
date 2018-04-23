package com.sh.game.system.user.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求创建角色</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqCreateRoleMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqCreateRoleMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 1003;
	}
	
	/**
	 * 角色名字
	 */
	private String roleName;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * 职业
	 */
	private int career;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

		public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

		public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.roleName = readString(buf);
		this.sex = readInt(buf, false);
		this.career = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeString(buf, roleName);
		this.writeInt(buf, sex, false);
		this.writeInt(buf, career, false);
		return true;
	}
}
