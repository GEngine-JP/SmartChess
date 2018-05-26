package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>9377角色查询接口</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class Req9377GetRoleInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public Req9377GetRoleInfoMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43036;
	}
	
	/**
	 * 登录账户名
	 */
	private String loginName;
	/**
	 * 渠道
	 */
	private int qudao;
	/**
	 * 服务器id
	 */
	private int sid;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

		public int getQudao() {
		return qudao;
	}

	public void setQudao(int qudao) {
		this.qudao = qudao;
	}

		public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.loginName = readString(buf);
		this.qudao = readInt(buf, false);
		this.sid = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeString(buf, loginName);
		this.writeInt(buf, qudao, false);
		this.writeInt(buf, sid, false);
		return true;
	}
}
