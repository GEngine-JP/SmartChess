package com.sh.game.system.duobao.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求进入夺宝</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqEnterduobaoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqEnterduobaoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48003;
	}
	
	/**
	 * 碎片id
	 */
	private int suipianId;


	public int getSuipianId() {
		return suipianId;
	}

	public void setSuipianId(int suipianId) {
		this.suipianId = suipianId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.suipianId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, suipianId, false);

		return true;
	}
}

