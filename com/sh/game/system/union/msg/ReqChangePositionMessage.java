package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求调整职位</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqChangePositionMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqChangePositionMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23009;
	}
	
	/**
	 * 选择的玩家ID
	 */
	private long memberId;
	/**
	 * 要调整的职位
	 */
	private int position;

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

		public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.memberId = readLong(buf);
		this.position = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, memberId);
		this.writeInt(buf, position, false);
		return true;
	}
}
