package com.sh.game.system.union.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class PositionInfo extends KryoBean {

	/**
	 * 会长
	 */
	private int master;
	/**
	 * 副会长
	 */
	private int master2;
	/**
	 * 长老
	 */
	private int numberTree;
	/**
	 * 护法
	 */
	private int numberFour;

	public int getMaster() {
		return master;
	}

	public void setMaster(int master) {
		this.master = master;
	}

		public int getMaster2() {
		return master2;
	}

	public void setMaster2(int master2) {
		this.master2 = master2;
	}

		public int getNumberTree() {
		return numberTree;
	}

	public void setNumberTree(int numberTree) {
		this.numberTree = numberTree;
	}

		public int getNumberFour() {
		return numberFour;
	}

	public void setNumberFour(int numberFour) {
		this.numberFour = numberFour;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.master = readInt(buf, false);
		this.master2 = readInt(buf, false);
		this.numberTree = readInt(buf, false);
		this.numberFour = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, master, false);
		this.writeInt(buf, master2, false);
		this.writeInt(buf, numberTree, false);
		this.writeInt(buf, numberFour, false);
		return true;
	}
}
