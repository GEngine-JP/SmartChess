package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求封禁</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqBackBanMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBackBanMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43026;
	}
	
	/**
	 * 1账号 2ip
	 */
	private int banType;
	/**
	 * 参数
	 */
	private String banParam;
	/**
	 * 封号理由
	 */
	private String banReason;
	/**
	 * 封禁时间（秒）
	 */
	private int time;

	public int getBanType() {
		return banType;
	}

	public void setBanType(int banType) {
		this.banType = banType;
	}

		public String getBanParam() {
		return banParam;
	}

	public void setBanParam(String banParam) {
		this.banParam = banParam;
	}

		public String getBanReason() {
		return banReason;
	}

	public void setBanReason(String banReason) {
		this.banReason = banReason;
	}

		public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.banType = readInt(buf, false);
		this.banParam = readString(buf);
		this.banReason = readString(buf);
		this.time = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, banType, false);
		this.writeString(buf, banParam);
		this.writeString(buf, banReason);
		this.writeInt(buf, time, false);
		return true;
	}
}
