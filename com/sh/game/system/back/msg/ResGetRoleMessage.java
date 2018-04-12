package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>查找角色</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResGetRoleMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResGetRoleMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43043;
	}
	
	/**
	 * 数据字节数组
	 */
	private byte[] byteArray;


	public byte[] getByteArray() {
		return byteArray;
	}

	public void setByteArray(byte[] byteArray) {
		this.byteArray = byteArray;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.byteArray = readBytes(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeBytes(buf, byteArray);

		return true;
	}
}

