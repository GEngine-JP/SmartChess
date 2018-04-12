package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.union.msg.bean.UnionRedPackBean;
import com.sh.game.system.union.msg.bean.UnionRedPackRecordBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>红包面板数据</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResOpenRedPackPanelMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOpenRedPackPanelMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23040;
	}
	
	/**
	 * 今日抢到的红包数
	 */
	private int todayCount;

	/**
	 * 今日抢到的红包总数
	 */
	private int todayMoney;

	/**
	 * 红包列表
	 */
	private List<UnionRedPackBean> unionRedPackBeanList = new ArrayList<UnionRedPackBean>();

	/**
	 * 红包记录列表
	 */
	private List<UnionRedPackRecordBean> unionRedPackRecordBean = new ArrayList<UnionRedPackRecordBean>();


	public int getTodayCount() {
		return todayCount;
	}

	public void setTodayCount(int todayCount) {
		this.todayCount = todayCount;
	}

	
	public int getTodayMoney() {
		return todayMoney;
	}

	public void setTodayMoney(int todayMoney) {
		this.todayMoney = todayMoney;
	}

	
	public List<UnionRedPackBean> getUnionRedPackBeanList() {
		return unionRedPackBeanList;
	}

	public void setUnionRedPackBeanList(List<UnionRedPackBean> unionRedPackBeanList) {
		this.unionRedPackBeanList = unionRedPackBeanList;
	}

	public List<UnionRedPackRecordBean> getUnionRedPackRecordBean() {
		return unionRedPackRecordBean;
	}

	public void setUnionRedPackRecordBean(List<UnionRedPackRecordBean> unionRedPackRecordBean) {
		this.unionRedPackRecordBean = unionRedPackRecordBean;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.todayCount = readInt(buf, false);
		this.todayMoney = readInt(buf, false);
		int unionRedPackBeanListLength = readShort(buf);
		for (int unionRedPackBeanListI = 0; unionRedPackBeanListI < unionRedPackBeanListLength; unionRedPackBeanListI++) {
			if (readByte(buf) == 0) { 
				this.unionRedPackBeanList.add(null);
			} else {
				UnionRedPackBean unionRedPackBean = new UnionRedPackBean();
				unionRedPackBean.read(buf);
				this.unionRedPackBeanList.add(unionRedPackBean);
			}
		}

		int unionRedPackRecordBeanLength = readShort(buf);
		for (int unionRedPackRecordBeanI = 0; unionRedPackRecordBeanI < unionRedPackRecordBeanLength; unionRedPackRecordBeanI++) {
			if (readByte(buf) == 0) { 
				this.unionRedPackRecordBean.add(null);
			} else {
				UnionRedPackRecordBean unionRedPackRecordBean = new UnionRedPackRecordBean();
				unionRedPackRecordBean.read(buf);
				this.unionRedPackRecordBean.add(unionRedPackRecordBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, todayCount, false);
		this.writeInt(buf, todayMoney, false);
		writeShort(buf, this.unionRedPackBeanList.size());
		for (int unionRedPackBeanListI = 0; unionRedPackBeanListI < this.unionRedPackBeanList.size(); unionRedPackBeanListI++) {
			this.writeBean(buf, this.unionRedPackBeanList.get(unionRedPackBeanListI));
		}

		writeShort(buf, this.unionRedPackRecordBean.size());
		for (int unionRedPackRecordBeanI = 0; unionRedPackRecordBeanI < this.unionRedPackRecordBean.size(); unionRedPackRecordBeanI++) {
			this.writeBean(buf, this.unionRedPackRecordBean.get(unionRedPackRecordBeanI));
		}


		return true;
	}
}

