package com.sh.game.system.redenvelop.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回领取红包结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDrawRedEnvelopMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDrawRedEnvelopMessage() {
		this.queueId = 0;
	}
	
	@Override
	public int getId() {
		return 63003;
	}
	
	/**
	 * 历史领取数量
	 */
	private int drawTotal;

	public int getDrawTotal() {
		return drawTotal;
	}

	public void setDrawTotal(int drawTotal) {
		this.drawTotal = drawTotal;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.drawTotal = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, drawTotal, false);
		return true;
	}
}
