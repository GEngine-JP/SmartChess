package com.sh.game.system.user.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>告知客户端需要创建角色</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResCreateRoleMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCreateRoleMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 1002;
	}
	
	/**
	 * 随机名字
	 */
	private long uid;

	/**
	 * 随机名字
	 */
	private String randomRoleName;


	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	
	public String getRandomRoleName() {
		return randomRoleName;
	}

	public void setRandomRoleName(String randomRoleName) {
		this.randomRoleName = randomRoleName;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.uid = readLong(buf);
		this.randomRoleName = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, uid);
		this.writeString(buf, randomRoleName);

		return true;
	}
}

