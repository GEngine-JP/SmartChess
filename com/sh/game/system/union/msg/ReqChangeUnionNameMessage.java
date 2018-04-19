package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求修改帮会名字</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqChangeUnionNameMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqChangeUnionNameMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23050;
	}
	
	/**
	 * 新帮会名字
	 */
	private String newUnionName;


	public String getNewUnionName() {
		return newUnionName;
	}

	public void setNewUnionName(String newUnionName) {
		this.newUnionName = newUnionName;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.newUnionName = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, newUnionName);

		return true;
	}
}

