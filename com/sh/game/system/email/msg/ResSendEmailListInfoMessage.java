package com.sh.game.system.email.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.email.msg.bean.EmailInfo;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送邮件列表</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendEmailListInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendEmailListInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 36002;
	}
	
	/**
	 * 邮件列表
	 */
	private List<EmailInfo> emailList = new ArrayList<EmailInfo>();


	public List<EmailInfo> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<EmailInfo> emailList) {
		this.emailList = emailList;
	}


	@Override
	public boolean read(KryoInput buf) {
		int emailListLength = readShort(buf);
		for (int emailListI = 0; emailListI < emailListLength; emailListI++) {
			if (readByte(buf) == 0) { 
				this.emailList.add(null);
			} else {
				EmailInfo emailInfo = new EmailInfo();
				emailInfo.read(buf);
				this.emailList.add(emailInfo);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.emailList.size());
		for (int emailListI = 0; emailListI < this.emailList.size(); emailListI++) {
			this.writeBean(buf, this.emailList.get(emailListI));
		}


		return true;
	}
}

