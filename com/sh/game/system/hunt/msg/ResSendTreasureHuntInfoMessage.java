package com.sh.game.system.hunt.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.hunt.msg.bean.TreasureHuntRecordBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>寻宝面板信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendTreasureHuntInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendTreasureHuntInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 11007;
	}
	
	/**
	 *  寻宝记录
	 */
	private List<TreasureHuntRecordBean> records = new ArrayList<TreasureHuntRecordBean>();

	/**
	 * 寻宝次数
	 */
	private int huntCount;


	public List<TreasureHuntRecordBean> getRecords() {
		return records;
	}

	public void setRecords(List<TreasureHuntRecordBean> records) {
		this.records = records;
	}

	public int getHuntCount() {
		return huntCount;
	}

	public void setHuntCount(int huntCount) {
		this.huntCount = huntCount;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		int recordsLength = readShort(buf);
		for (int recordsI = 0; recordsI < recordsLength; recordsI++) {
			if (readByte(buf) == 0) { 
				this.records.add(null);
			} else {
				TreasureHuntRecordBean treasureHuntRecordBean = new TreasureHuntRecordBean();
				treasureHuntRecordBean.read(buf);
				this.records.add(treasureHuntRecordBean);
			}
		}

		this.huntCount = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.records.size());
		for (int recordsI = 0; recordsI < this.records.size(); recordsI++) {
			this.writeBean(buf, this.records.get(recordsI));
		}

		this.writeInt(buf, huntCount, false);

		return true;
	}
}

