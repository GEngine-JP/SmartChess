package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.union.msg.bean.UnionSettingBean;

/**
 * <p>发送帮会设置信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendUnionSetUpMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendUnionSetUpMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23024;
	}
	
	/**
	 * 设置状态
	 */
	private UnionSettingBean settingState;

	public UnionSettingBean getSettingState() {
		return settingState;
	}

	public void setSettingState(UnionSettingBean settingState) {
		this.settingState = settingState;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			UnionSettingBean unionSettingBean = new UnionSettingBean();
			unionSettingBean.read(buf);
			this.settingState = unionSettingBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, settingState);
		return true;
	}
}
