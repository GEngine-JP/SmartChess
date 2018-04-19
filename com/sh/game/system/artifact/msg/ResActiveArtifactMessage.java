package com.sh.game.system.artifact.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回激活神器</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResActiveArtifactMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResActiveArtifactMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 52002;
	}
	
	/**
	 * id
	 */
	private int artifactId;


	public int getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(int artifactId) {
		this.artifactId = artifactId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.artifactId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, artifactId, false);

		return true;
	}
}

