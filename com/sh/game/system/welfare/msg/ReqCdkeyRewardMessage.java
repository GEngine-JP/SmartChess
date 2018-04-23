package com.sh.game.system.welfare.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求cdkey领奖</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqCdkeyRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqCdkeyRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 27003;
	}
	
	/**
	 * cdkey
	 */
	private String cdkey;

	public String getCdkey() {
		return cdkey;
	}

	public void setCdkey(String cdkey) {
		this.cdkey = cdkey;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.cdkey = readString(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeString(buf, cdkey);
		return true;
	}
}
