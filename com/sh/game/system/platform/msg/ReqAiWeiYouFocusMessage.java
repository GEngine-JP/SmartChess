package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>爱微游关注奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqAiWeiYouFocusMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqAiWeiYouFocusMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44003;
	}
	
	/**
	 * 是否关注公从号0否1是
	 */
	private int focus;

	public int getFocus() {
		return focus;
	}

	public void setFocus(int focus) {
		this.focus = focus;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.focus = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, focus, false);
		return true;
	}
}
