package com.sh.game.system.title.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送威名信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResTitleInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResTitleInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 33001;
	}
	
	/**
	 * 威名等级
	 */
	private int level;

	/**
	 * 威望排名 1第一 2第二 3第三 0其他
	 */
	private int rank;

	/**
	 * 第一名光翼id
	 */
	private int windId;

	/**
	 * 第一名性别
	 */
	private int sex;

	/**
	 * 第一名职业
	 */
	private int career;

	/**
	 * 第一名名字
	 */
	private String roleName;

	/**
	 * 第一名装备列表
	 */
	private List<Integer> equipmentList = new ArrayList<Integer>();


	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	public int getWindId() {
		return windId;
	}

	public void setWindId(int windId) {
		this.windId = windId;
	}

	
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	
	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	public List<Integer> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(List<Integer> equipmentList) {
		this.equipmentList = equipmentList;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.level = readInt(buf, false);
		this.rank = readInt(buf, false);
		this.windId = readInt(buf, false);
		this.sex = readInt(buf, false);
		this.career = readInt(buf, false);
		this.roleName = readString(buf);
		int equipmentListLength = readShort(buf);
		for (int equipmentListI = 0; equipmentListI < equipmentListLength; equipmentListI++) {
			this.equipmentList.add(this.readInt(buf, false));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, level, false);
		this.writeInt(buf, rank, false);
		this.writeInt(buf, windId, false);
		this.writeInt(buf, sex, false);
		this.writeInt(buf, career, false);
		this.writeString(buf, roleName);
		writeShort(buf, this.equipmentList.size());
		for (int equipmentListI = 0; equipmentListI < this.equipmentList.size(); equipmentListI++) {
			this.writeInt(buf, this.equipmentList.get(equipmentListI), false);
		}


		return true;
	}
}

