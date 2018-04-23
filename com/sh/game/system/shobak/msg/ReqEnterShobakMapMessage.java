package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求进入沙巴克地图</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqEnterShobakMapMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqEnterShobakMapMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40007;
	}
	
	/**
	 * 进入的地图id殿外殿前皇宫
	 */
	private int mapId;

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.mapId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, mapId, false);
		return true;
	}
}
