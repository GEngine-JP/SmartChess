package com.sh.game.system.mining.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求监工</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqOverseerMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOverseerMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48003;
	}
	
	/**
	 * 监工时间目前是4h,8h,12h 我发1,2,3 对应4,8,12小时
	 */
	private int type;


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);

		return true;
	}
}

