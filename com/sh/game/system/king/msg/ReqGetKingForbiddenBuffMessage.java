package com.sh.game.system.king.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求领取王者禁地buff</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetKingForbiddenBuffMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetKingForbiddenBuffMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 45009;
	}
	
	/**
	 * 选择的buff位置从0开始
	 */
	private int position;


	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.position = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, position, false);

		return true;
	}
}

