package com.sh.game.system.artifact.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回当前神器激活状态</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResCurrentArtifactMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCurrentArtifactMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 52002;
	}
	
	/**
	 * artifactId
	 */
	private int artifactId;

	/**
	 * 0未激活 1可激活 2己激活
	 */
	private int state;


	public int getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(int artifactId) {
		this.artifactId = artifactId;
	}

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.artifactId = readInt(buf, false);
		this.state = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, artifactId, false);
		this.writeInt(buf, state, false);

		return true;
	}
}

