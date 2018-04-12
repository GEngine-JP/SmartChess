package com.sh.game.system.threesword.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.threesword.msg.bean.ThreeSwordBean;


/**
 * <p>返回升级后的信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResLevelUpThreeSwordInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLevelUpThreeSwordInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 46003;
	}
	
	/**
	 * 三才装备信息
	 */
	private ThreeSwordBean threeSwordInfo;


	public ThreeSwordBean getThreeSwordInfo() {
		return threeSwordInfo;
	}

	public void setThreeSwordInfo(ThreeSwordBean threeSwordInfo) {
		this.threeSwordInfo = threeSwordInfo;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		if (readByte(buf) != 0) {
			ThreeSwordBean threeSwordBean = new ThreeSwordBean();
			threeSwordBean.read(buf);
			this.threeSwordInfo = threeSwordBean;
		}

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeBean(buf, threeSwordInfo);

		return true;
	}
}

