package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回后台请求的结果信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResBackRetMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResBackRetMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43004;
	}
	
	/**
	 * 返回信息
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

