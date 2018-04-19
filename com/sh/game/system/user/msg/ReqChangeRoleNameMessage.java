package com.sh.game.system.user.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>玩家改名</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqChangeRoleNameMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqChangeRoleNameMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 1012;
	}
	
	/**
	 * 新名字
	 */
	private String newName;


	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.newName = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, newName);

		return true;
	}
}

