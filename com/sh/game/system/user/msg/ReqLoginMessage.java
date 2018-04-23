package com.sh.game.system.user.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求登录</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqLoginMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLoginMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 1001;
	}
	
	/**
	 * 登录账户
	 */
	private String loginName;
	/**
	 * 服务器id
	 */
	private int sid;
	/**
	 * 平台id
	 */
	private int pid;
	/**
	 * 登录方式（1、网页，2、微端
	 */
	private int client;
	/**
	 * 身份证号码
	 */
	private String idNumber;
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * 版本号
	 */
	private int version;
	/**
	 * channelId
	 */
	private String channelId;
	/**
	 * 渠道
	 */
	private String qudao;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

		public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

		public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

		public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

		public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

		public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

		public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

		public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

		public String getQudao() {
		return qudao;
	}

	public void setQudao(String qudao) {
		this.qudao = qudao;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.loginName = readString(buf);
		this.sid = readInt(buf, false);
		this.pid = readInt(buf, false);
		this.client = readInt(buf, false);
		this.idNumber = readString(buf);
		this.ip = readString(buf);
		this.version = readInt(buf, false);
		this.channelId = readString(buf);
		this.qudao = readString(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeString(buf, loginName);
		this.writeInt(buf, sid, false);
		this.writeInt(buf, pid, false);
		this.writeInt(buf, client, false);
		this.writeString(buf, idNumber);
		this.writeString(buf, ip);
		this.writeInt(buf, version, false);
		this.writeString(buf, channelId);
		this.writeString(buf, qudao);
		return true;
	}
}
