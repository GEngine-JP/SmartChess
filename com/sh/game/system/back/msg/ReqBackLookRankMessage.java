package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>后台请求查看排行榜</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqBackLookRankMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBackLookRankMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43010;
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

