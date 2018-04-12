package com.sh.game.system.count.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.count.msg.bean.CountBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回数量的列表</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResCountDataMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCountDataMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 21001;
	}
	
	/**
	 * 数量列表
	 */
	private List<CountBean> countList = new ArrayList<CountBean>();


	public List<CountBean> getCountList() {
		return countList;
	}

	public void setCountList(List<CountBean> countList) {
		this.countList = countList;
	}


	@Override
	public boolean read(KryoInput buf) {
		int countListLength = readShort(buf);
		for (int countListI = 0; countListI < countListLength; countListI++) {
			if (readByte(buf) == 0) { 
				this.countList.add(null);
			} else {
				CountBean countBean = new CountBean();
				countBean.read(buf);
				this.countList.add(countBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.countList.size());
		for (int countListI = 0; countListI < this.countList.size(); countListI++) {
			this.writeBean(buf, this.countList.get(countListI));
		}


		return true;
	}
}

