package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求获取内存数据</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqFetchMemoryMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqFetchMemoryMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43038;
	}
	
	/**
	 * 数据类型
	 */
	private int tableType;

	/**
	 * id
	 */
	private long mid;


	public int getTableType() {
		return tableType;
	}

	public void setTableType(int tableType) {
		this.tableType = tableType;
	}

	
	public long getMid() {
		return mid;
	}

	public void setMid(long mid) {
		this.mid = mid;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.tableType = readInt(buf, false);
		this.mid = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, tableType, false);
		this.writeLong(buf, mid);

		return true;
	}
}

