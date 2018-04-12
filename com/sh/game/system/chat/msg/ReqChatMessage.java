package com.sh.game.system.chat.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>聊天</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqChatMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqChatMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 6003;
	}
	
	/**
	 * 私聊的时候的目标，其他情况发0
	 */
	private long targetUid;

	/**
	 * 聊天类型
	 */
	private int chatType;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 道具唯一Id
	 */
	private List<Long> uniqueId = new ArrayList<Long>();

	/**
	 * 道具id
	 */
	private List<Integer> itemId = new ArrayList<Integer>();


	public long getTargetUid() {
		return targetUid;
	}

	public void setTargetUid(long targetUid) {
		this.targetUid = targetUid;
	}

	
	public int getChatType() {
		return chatType;
	}

	public void setChatType(int chatType) {
		this.chatType = chatType;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public List<Long> getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(List<Long> uniqueId) {
		this.uniqueId = uniqueId;
	}

	public List<Integer> getItemId() {
		return itemId;
	}

	public void setItemId(List<Integer> itemId) {
		this.itemId = itemId;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.targetUid = readLong(buf);
		this.chatType = readInt(buf, false);
		this.content = readString(buf);
		int uniqueIdLength = readShort(buf);
		for (int uniqueIdI = 0; uniqueIdI < uniqueIdLength; uniqueIdI++) {
			this.uniqueId.add(this.readLong(buf));
		}

		int itemIdLength = readShort(buf);
		for (int itemIdI = 0; itemIdI < itemIdLength; itemIdI++) {
			this.itemId.add(this.readInt(buf, false));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, targetUid);
		this.writeInt(buf, chatType, false);
		this.writeString(buf, content);
		writeShort(buf, this.uniqueId.size());
		for (int uniqueIdI = 0; uniqueIdI < this.uniqueId.size(); uniqueIdI++) {
			this.writeLong(buf, this.uniqueId.get(uniqueIdI));
		}

		writeShort(buf, this.itemId.size());
		for (int itemIdI = 0; itemIdI < this.itemId.size(); itemIdI++) {
			this.writeInt(buf, this.itemId.get(itemIdI), false);
		}


		return true;
	}
}

