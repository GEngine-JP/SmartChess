package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.union.msg.bean.UnionRedPackBean;

/**
 * <p>请求重置行會挑戰</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResUnionRedPackInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResUnionRedPackInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23047;
	}
	
	/**
	 * 红包信息
	 */
	private UnionRedPackBean unionRedPackBean;

	public UnionRedPackBean getUnionRedPackBean() {
		return unionRedPackBean;
	}

	public void setUnionRedPackBean(UnionRedPackBean unionRedPackBean) {
		this.unionRedPackBean = unionRedPackBean;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			UnionRedPackBean unionRedPackBean = new UnionRedPackBean();
			unionRedPackBean.read(buf);
			this.unionRedPackBean = unionRedPackBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, unionRedPackBean);
		return true;
	}
}
