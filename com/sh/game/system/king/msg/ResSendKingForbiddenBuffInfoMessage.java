package com.sh.game.system.king.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送王者禁地buff属性信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendKingForbiddenBuffInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendKingForbiddenBuffInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 45010;
	}
	
	/**
	 * 要显示的属性buff
	 */
	private List<Integer> buffIds = new ArrayList<Integer>();

	/**
	 * 已拥有的属性buff
	 */
	private List<Integer> hasBuffIds = new ArrayList<Integer>();

	/**
	 * 剩余属性领取次数
	 */
	private int remainNum;

	/**
	 * 属性加的战斗力
	 */
	private int nbValue;


	public List<Integer> getBuffIds() {
		return buffIds;
	}

	public void setBuffIds(List<Integer> buffIds) {
		this.buffIds = buffIds;
	}

	public List<Integer> getHasBuffIds() {
		return hasBuffIds;
	}

	public void setHasBuffIds(List<Integer> hasBuffIds) {
		this.hasBuffIds = hasBuffIds;
	}

	public int getRemainNum() {
		return remainNum;
	}

	public void setRemainNum(int remainNum) {
		this.remainNum = remainNum;
	}

	
	public int getNbValue() {
		return nbValue;
	}

	public void setNbValue(int nbValue) {
		this.nbValue = nbValue;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		int buffIdsLength = readShort(buf);
		for (int buffIdsI = 0; buffIdsI < buffIdsLength; buffIdsI++) {
			this.buffIds.add(this.readInt(buf, false));
		}

		int hasBuffIdsLength = readShort(buf);
		for (int hasBuffIdsI = 0; hasBuffIdsI < hasBuffIdsLength; hasBuffIdsI++) {
			this.hasBuffIds.add(this.readInt(buf, false));
		}

		this.remainNum = readInt(buf, false);
		this.nbValue = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.buffIds.size());
		for (int buffIdsI = 0; buffIdsI < this.buffIds.size(); buffIdsI++) {
			this.writeInt(buf, this.buffIds.get(buffIdsI), false);
		}

		writeShort(buf, this.hasBuffIds.size());
		for (int hasBuffIdsI = 0; hasBuffIdsI < this.hasBuffIds.size(); hasBuffIdsI++) {
			this.writeInt(buf, this.hasBuffIds.get(hasBuffIdsI), false);
		}

		this.writeInt(buf, remainNum, false);
		this.writeInt(buf, nbValue, false);

		return true;
	}
}

