package com.sh.game.system.email.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>请求获取邮件附件</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetEmailAttachmentMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetEmailAttachmentMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 36005;
	}
	
	/**
	 * 要提取的邮件id
	 */
	private List<Long> emailIds = new ArrayList<>();

	public List<Long> getEmailIds() {
		return emailIds;
	}

	public void setEmailIds(List<Long> emailIds) {
		this.emailIds = emailIds;
	}

	@Override
	public boolean read(KryoInput buf) {

		int emailIdsLength = readShort(buf);
		for (int emailIdsI = 0; emailIdsI < emailIdsLength; emailIdsI++) {
			this.emailIds.add(this.readLong(buf));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.emailIds.size());
		for (int emailIdsI = 0; emailIdsI < this.emailIds.size(); emailIdsI++) {
			this.writeLong(buf, this.emailIds.get(emailIdsI));
		}
		return true;
	}
}
