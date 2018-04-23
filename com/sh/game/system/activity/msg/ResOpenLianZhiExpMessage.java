package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回经验炼制面板</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResOpenLianZhiExpMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOpenLianZhiExpMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4010;
	}
	
	/**
	 * 类型
	 */
	private int type;
	/**
	 * 次数
	 */
	private int count;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.count = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeInt(buf, count, false);
		return true;
	}
}
