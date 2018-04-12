package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回内存数据</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResFetchMemoryMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResFetchMemoryMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43039;
	}
	
	/**
	 * 数据类型
	 */
	private int tableType;

	/**
	 * id
	 */
	private long mid;

	/**
	 * 数据字节数组
	 */
	private byte[] byteArray;


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

	
	public byte[] getByteArray() {
		return byteArray;
	}

	public void setByteArray(byte[] byteArray) {
		this.byteArray = byteArray;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.tableType = readInt(buf, false);
		this.mid = readLong(buf);
		this.byteArray = readBytes(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, tableType, false);
		this.writeLong(buf, mid);
		this.writeBytes(buf, byteArray);

		return true;
	}
}

