package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>获取独角兽信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqDjsInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqDjsInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44013;
	}
	
	/**
	 * channelId
	 */
	private String channelId;


	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.channelId = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, channelId);

		return true;
	}
}

