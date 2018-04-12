package com.sh.game.system.duobao.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.duobao.msg.bean.SuipianBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回夺宝信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResDuobaoInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDuobaoInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48002;
	}
	
	/**
	 * 碎片
	 */
	private List<SuipianBean> suiPianList = new ArrayList<SuipianBean>();


	public List<SuipianBean> getSuiPianList() {
		return suiPianList;
	}

	public void setSuiPianList(List<SuipianBean> suiPianList) {
		this.suiPianList = suiPianList;
	}


	@Override
	public boolean read(KryoInput buf) {
		int suiPianListLength = readShort(buf);
		for (int suiPianListI = 0; suiPianListI < suiPianListLength; suiPianListI++) {
			if (readByte(buf) == 0) { 
				this.suiPianList.add(null);
			} else {
				SuipianBean suipianBean = new SuipianBean();
				suipianBean.read(buf);
				this.suiPianList.add(suipianBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.suiPianList.size());
		for (int suiPianListI = 0; suiPianListI < this.suiPianList.size(); suiPianListI++) {
			this.writeBean(buf, this.suiPianList.get(suiPianListI));
		}


		return true;
	}
}

