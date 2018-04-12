package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.union.msg.bean.UnionInfoBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送帮会列表信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendAllUnionInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendAllUnionInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23003;
	}
	
	/**
	 * 帮会列表信息
	 */
	private List<UnionInfoBean> unionInfo = new ArrayList<UnionInfoBean>();


	public List<UnionInfoBean> getUnionInfo() {
		return unionInfo;
	}

	public void setUnionInfo(List<UnionInfoBean> unionInfo) {
		this.unionInfo = unionInfo;
	}


	@Override
	public boolean read(KryoInput buf) {
		int unionInfoLength = readShort(buf);
		for (int unionInfoI = 0; unionInfoI < unionInfoLength; unionInfoI++) {
			if (readByte(buf) == 0) { 
				this.unionInfo.add(null);
			} else {
				UnionInfoBean unionInfoBean = new UnionInfoBean();
				unionInfoBean.read(buf);
				this.unionInfo.add(unionInfoBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.unionInfo.size());
		for (int unionInfoI = 0; unionInfoI < this.unionInfo.size(); unionInfoI++) {
			this.writeBean(buf, this.unionInfo.get(unionInfoI));
		}


		return true;
	}
}

