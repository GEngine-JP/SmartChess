package com.sh.game.system.chapter.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求打开关卡排行面板</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqOpenChapterPanelMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOpenChapterPanelMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 41005;
	}
	


	@Override
	public boolean read(KryoInput buf) {


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {


		return true;
	}
}
