package com.sh.game.system.duobao.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;

import com.sh.game.system.duobao.msg.bean.SuipianBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class LingBaoBean extends KryoBean {

	/**
	 * 灵宝id
	 */
	private int lingbaoId;

	/**
	 * 碎片数组
	 */
	private List<SuipianBean> suipian = new ArrayList<SuipianBean>();


	public int getLingbaoId() {
		return lingbaoId;
	}

	public void setLingbaoId(int lingbaoId) {
		this.lingbaoId = lingbaoId;
	}

	
	public List<SuipianBean> getSuipian() {
		return suipian;
	}

	public void setSuipian(List<SuipianBean> suipian) {
		this.suipian = suipian;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.lingbaoId = readInt(buf, false);
		int suipianLength = readShort(buf);
		for (int suipianI = 0; suipianI < suipianLength; suipianI++) {
			if (readByte(buf) == 0) { 
				this.suipian.add(null);
			} else {
				SuipianBean suipianBean = new SuipianBean();
				suipianBean.read(buf);
				this.suipian.add(suipianBean);
			}
		}


		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, lingbaoId, false);
		writeShort(buf, this.suipian.size());
		for (int suipianI = 0; suipianI < this.suipian.size(); suipianI++) {
			this.writeBean(buf, this.suipian.get(suipianI));
		}


		return true;
	}
}

