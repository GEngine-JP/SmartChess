package com.sh.game.system.chat.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.chat.msg.bean.OtherMsgBean;
import com.sh.game.system.chat.msg.bean.ChatItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>聊天结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResChatMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResChatMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 6004;
	}
	
	/**
	 * 聊天内容
	 */
	private String content;
	/**
	 * 聊天类型
	 */
	private int type;
	/**
	 * 其他杂七杂八的东西
	 */
	private OtherMsgBean otherMsgBean;
	/**
	 * 聊天道具信息
	 */
	private List<ChatItemBean> itemInfoBeans = new ArrayList<>();

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

		public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public OtherMsgBean getOtherMsgBean() {
		return otherMsgBean;
	}

	public void setOtherMsgBean(OtherMsgBean otherMsgBean) {
		this.otherMsgBean = otherMsgBean;
	}

		public List<ChatItemBean> getItemInfoBeans() {
		return itemInfoBeans;
	}

	public void setItemInfoBeans(List<ChatItemBean> itemInfoBeans) {
		this.itemInfoBeans = itemInfoBeans;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.content = readString(buf);
		this.type = readInt(buf, false);
		if (readByte(buf) != 0) {
			OtherMsgBean otherMsgBean = new OtherMsgBean();
			otherMsgBean.read(buf);
			this.otherMsgBean = otherMsgBean;
		}
		int itemInfoBeansLength = readShort(buf);
		for (int itemInfoBeansI = 0; itemInfoBeansI < itemInfoBeansLength; itemInfoBeansI++) {
			if (readByte(buf) == 0) { 
				this.itemInfoBeans.add(null);
			} else {
				ChatItemBean chatItemBean = new ChatItemBean();
				chatItemBean.read(buf);
				this.itemInfoBeans.add(chatItemBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeString(buf, content);
		this.writeInt(buf, type, false);
		this.writeBean(buf, otherMsgBean);
		writeShort(buf, this.itemInfoBeans.size());
		for (int itemInfoBeansI = 0; itemInfoBeansI < this.itemInfoBeans.size(); itemInfoBeansI++) {
			this.writeBean(buf, this.itemInfoBeans.get(itemInfoBeansI));
		}
		return true;
	}
}
