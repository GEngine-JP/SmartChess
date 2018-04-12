package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>更新内存数据结果</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResPushMemoryMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResPushMemoryMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43041;
	}
	
	/**
	 * 结果
	 */
	private String ret;


	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.ret = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, ret);

		return true;
	}
}

