package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求打开夺宝目标页面</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqRobTreasureTargetListMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRobTreasureTargetListMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50003;
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
