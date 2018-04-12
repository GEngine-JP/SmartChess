package com.sh.game.system.email.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>删除邮件</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResDeleteEmailMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDeleteEmailMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 36007;
	}
	
	/**
	 * 删除的邮件id
	 */
	private List<Long> emailId = new ArrayList<Long>();


	public List<Long> getEmailId() {
		return emailId;
	}

	public void setEmailId(List<Long> emailId) {
		this.emailId = emailId;
	}


	@Override
	public boolean read(KryoInput buf) {
		int emailIdLength = readShort(buf);
		for (int emailIdI = 0; emailIdI < emailIdLength; emailIdI++) {
			this.emailId.add(this.readLong(buf));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.emailId.size());
		for (int emailIdI = 0; emailIdI < this.emailId.size(); emailIdI++) {
			this.writeLong(buf, this.emailId.get(emailIdI));
		}


		return true;
	}
}

