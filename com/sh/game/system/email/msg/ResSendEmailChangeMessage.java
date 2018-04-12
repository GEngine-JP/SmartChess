package com.sh.game.system.email.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.email.msg.bean.EmailInfo;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送邮件改变请求</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendEmailChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendEmailChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 36004;
	}
	
	/**
	 * 改变的邮件信息
	 */
	private List<EmailInfo> emailInfo = new ArrayList<EmailInfo>();


	public List<EmailInfo> getEmailInfo() {
		return emailInfo;
	}

	public void setEmailInfo(List<EmailInfo> emailInfo) {
		this.emailInfo = emailInfo;
	}


	@Override
	public boolean read(KryoInput buf) {
		int emailInfoLength = readShort(buf);
		for (int emailInfoI = 0; emailInfoI < emailInfoLength; emailInfoI++) {
			if (readByte(buf) == 0) { 
				this.emailInfo.add(null);
			} else {
				EmailInfo emailInfo = new EmailInfo();
				emailInfo.read(buf);
				this.emailInfo.add(emailInfo);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.emailInfo.size());
		for (int emailInfoI = 0; emailInfoI < this.emailInfo.size(); emailInfoI++) {
			this.writeBean(buf, this.emailInfo.get(emailInfoI));
		}


		return true;
	}
}

