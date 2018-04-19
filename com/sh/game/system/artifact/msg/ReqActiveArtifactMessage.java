package com.sh.game.system.artifact.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求激活神器</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqActiveArtifactMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqActiveArtifactMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 52001;
	}
	
	/**
	 * id
	 */
	private int id;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.id = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, id, false);

		return true;
	}
}

