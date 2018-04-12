package com.sh.game.system.title.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class TitleBean extends KryoBean {

	/**
	 * 称号id
	 */
	private int titleId;

	/**
	 * 过期时间
	 */
	private int timeout;


	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	
	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.titleId = readInt(buf, false);
		this.timeout = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, titleId, false);
		this.writeInt(buf, timeout, false);

		return true;
	}
}

