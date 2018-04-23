package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>通过id发邮件（后台用）</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqSendEmail2Message extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqSendEmail2Message() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43016;
	}
	
	/**
	 * 收件人id
	 */
	private long targetId;
	/**
	 * 邮件Id
	 */
	private int emailConfigId;

	public long getTargetId() {
		return targetId;
	}

	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}

		public int getEmailConfigId() {
		return emailConfigId;
	}

	public void setEmailConfigId(int emailConfigId) {
		this.emailConfigId = emailConfigId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.targetId = readLong(buf);
		this.emailConfigId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, targetId);
		this.writeInt(buf, emailConfigId, false);
		return true;
	}
}
