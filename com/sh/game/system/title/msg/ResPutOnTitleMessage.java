package com.sh.game.system.title.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.title.msg.bean.TitleBean;

/**
 * <p>返回佩戴称号</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResPutOnTitleMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResPutOnTitleMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 33007;
	}
	
	/**
	 * 称号信息
	 */
	private TitleBean titleBean;

	public TitleBean getTitleBean() {
		return titleBean;
	}

	public void setTitleBean(TitleBean titleBean) {
		this.titleBean = titleBean;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			TitleBean titleBean = new TitleBean();
			titleBean.read(buf);
			this.titleBean = titleBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, titleBean);
		return true;
	}
}
