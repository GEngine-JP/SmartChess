package com.sh.game.system.boss.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求BOSS面板信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqOpenBossInfoByTypeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOpenBossInfoByTypeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 30001;
	}
	
	/**
	 * 类型
	 */
	private int type;


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);

		return true;
	}
}

