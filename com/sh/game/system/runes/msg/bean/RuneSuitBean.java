package com.sh.game.system.runes.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;

import java.util.List;
import java.util.ArrayList;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class RuneSuitBean extends KryoBean {

	/**
	 * 装备位置列表
	 */
	private List<Integer> indexList = new ArrayList<Integer>();

	/**
	 * 老套装id列表
	 */
	private List<Integer> oldSuitList = new ArrayList<Integer>();

	/**
	 * 新套装id
	 */
	private int newSuit;


	public List<Integer> getIndexList() {
		return indexList;
	}

	public void setIndexList(List<Integer> indexList) {
		this.indexList = indexList;
	}

	public List<Integer> getOldSuitList() {
		return oldSuitList;
	}

	public void setOldSuitList(List<Integer> oldSuitList) {
		this.oldSuitList = oldSuitList;
	}

	public int getNewSuit() {
		return newSuit;
	}

	public void setNewSuit(int newSuit) {
		this.newSuit = newSuit;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		int indexListLength = readShort(buf);
		for (int indexListI = 0; indexListI < indexListLength; indexListI++) {
			this.indexList.add(this.readInt(buf, false));
		}

		int oldSuitListLength = readShort(buf);
		for (int oldSuitListI = 0; oldSuitListI < oldSuitListLength; oldSuitListI++) {
			this.oldSuitList.add(this.readInt(buf, false));
		}

		this.newSuit = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.indexList.size());
		for (int indexListI = 0; indexListI < this.indexList.size(); indexListI++) {
			this.writeInt(buf, this.indexList.get(indexListI), false);
		}

		writeShort(buf, this.oldSuitList.size());
		for (int oldSuitListI = 0; oldSuitListI < this.oldSuitList.size(); oldSuitListI++) {
			this.writeInt(buf, this.oldSuitList.get(oldSuitListI), false);
		}

		this.writeInt(buf, newSuit, false);

		return true;
	}
}

