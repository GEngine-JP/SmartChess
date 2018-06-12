package com.sh.game.system.warehouse.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求世界仓库库存信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetWarehouseItemInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetWarehouseItemInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 66001;
	}
	


	@Override
	public boolean read(KryoInput buf) {


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {


		return true;
	}
}
