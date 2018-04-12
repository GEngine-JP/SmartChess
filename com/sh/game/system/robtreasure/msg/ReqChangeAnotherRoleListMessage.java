package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求换一批玩家</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqChangeAnotherRoleListMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqChangeAnotherRoleListMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50005;
	}
	
	/**
	 * 碎片id
	 */
	private int fragmentId;


	public int getFragmentId() {
		return fragmentId;
	}

	public void setFragmentId(int fragmentId) {
		this.fragmentId = fragmentId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.fragmentId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, fragmentId, false);

		return true;
	}
}

