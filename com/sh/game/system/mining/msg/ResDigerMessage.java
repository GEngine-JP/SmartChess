package com.sh.game.system.mining.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.mining.msg.bean.MinerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送矿工信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDigerMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDigerMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48006;
	}
	
	/**
	 * 矿工列表
	 */
	private List<MinerBean> minerList = new ArrayList<>();

	public List<MinerBean> getMinerList() {
		return minerList;
	}

	public void setMinerList(List<MinerBean> minerList) {
		this.minerList = minerList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int minerListLength = readShort(buf);
		for (int minerListI = 0; minerListI < minerListLength; minerListI++) {
			if (readByte(buf) == 0) { 
				this.minerList.add(null);
			} else {
				MinerBean minerBean = new MinerBean();
				minerBean.read(buf);
				this.minerList.add(minerBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.minerList.size());
		for (int minerListI = 0; minerListI < this.minerList.size(); minerListI++) {
			this.writeBean(buf, this.minerList.get(minerListI));
		}
		return true;
	}
}
