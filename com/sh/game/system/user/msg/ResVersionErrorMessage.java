package com.sh.game.system.user.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>版本错误的返回消息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResVersionErrorMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResVersionErrorMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 1011;
	}
	
	/**
	 * 版本
	 */
	private int version;


	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.version = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, version, false);

		return true;
	}
}

