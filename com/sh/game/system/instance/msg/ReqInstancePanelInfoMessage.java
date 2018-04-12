package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求副本面板信息（通用）</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqInstancePanelInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqInstancePanelInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20014;
	}
	
	/**
	 * 副本类型
	 */
	private int insType;


	public int getInsType() {
		return insType;
	}

	public void setInsType(int insType) {
		this.insType = insType;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.insType = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, insType, false);

		return true;
	}
}

