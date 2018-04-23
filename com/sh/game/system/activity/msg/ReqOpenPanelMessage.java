package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求打开活动面板</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqOpenPanelMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOpenPanelMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4003;
	}
	
	/**
	 * 组id
	 */
	private int groupId;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.groupId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, groupId, false);
		return true;
	}
}
