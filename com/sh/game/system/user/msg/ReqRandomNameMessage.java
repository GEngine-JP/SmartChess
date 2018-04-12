package com.sh.game.system.user.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>随机名字</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqRandomNameMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRandomNameMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 1004;
	}
	
	/**
	 * 性别
	 */
	private int sex;


	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.sex = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, sex, false);

		return true;
	}
}

