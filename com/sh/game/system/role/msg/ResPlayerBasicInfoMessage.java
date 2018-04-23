package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.role.msg.bean.PlayerAttribute;

/**
 * <p>玩家基本数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResPlayerBasicInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResPlayerBasicInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8002;
	}
	
	/**
	 * 战斗力
	 */
	private int power;
	/**
	 * 属性
	 */
	private PlayerAttribute attr;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 等级
	 */
	private int level;
	/**
	 * 转生等级
	 */
	private int reinLevel;
	/**
	 * 职业
	 */
	private int career;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * 经验
	 */
	private long exp;
	/**
	 * 关卡进度
	 */
	private int advance;
	/**
	 * 击杀小怪进度
	 */
	private int wave;
	/**
	 * 佩戴的称号
	 */
	private int titleId;
	/**
	 * 佩戴的时装
	 */
	private int fashionId;
	/**
	 * 佩戴的光冀
	 */
	private int fashionWingId;
	/**
	 * 佩戴的幻武
	 */
	private int huanwu;

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

		public PlayerAttribute getAttr() {
		return attr;
	}

	public void setAttr(PlayerAttribute attr) {
		this.attr = attr;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

		public int getReinLevel() {
		return reinLevel;
	}

	public void setReinLevel(int reinLevel) {
		this.reinLevel = reinLevel;
	}

		public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

		public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

		public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

		public int getAdvance() {
		return advance;
	}

	public void setAdvance(int advance) {
		this.advance = advance;
	}

		public int getWave() {
		return wave;
	}

	public void setWave(int wave) {
		this.wave = wave;
	}

		public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

		public int getFashionId() {
		return fashionId;
	}

	public void setFashionId(int fashionId) {
		this.fashionId = fashionId;
	}

		public int getFashionWingId() {
		return fashionWingId;
	}

	public void setFashionWingId(int fashionWingId) {
		this.fashionWingId = fashionWingId;
	}

		public int getHuanwu() {
		return huanwu;
	}

	public void setHuanwu(int huanwu) {
		this.huanwu = huanwu;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.power = readInt(buf, false);
		if (readByte(buf) != 0) {
			PlayerAttribute playerAttribute = new PlayerAttribute();
			playerAttribute.read(buf);
			this.attr = playerAttribute;
		}
		this.name = readString(buf);
		this.level = readInt(buf, false);
		this.reinLevel = readInt(buf, false);
		this.career = readInt(buf, false);
		this.sex = readInt(buf, false);
		this.exp = readLong(buf);
		this.advance = readInt(buf, false);
		this.wave = readInt(buf, false);
		this.titleId = readInt(buf, false);
		this.fashionId = readInt(buf, false);
		this.fashionWingId = readInt(buf, false);
		this.huanwu = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, power, false);
		this.writeBean(buf, attr);
		this.writeString(buf, name);
		this.writeInt(buf, level, false);
		this.writeInt(buf, reinLevel, false);
		this.writeInt(buf, career, false);
		this.writeInt(buf, sex, false);
		this.writeLong(buf, exp);
		this.writeInt(buf, advance, false);
		this.writeInt(buf, wave, false);
		this.writeInt(buf, titleId, false);
		this.writeInt(buf, fashionId, false);
		this.writeInt(buf, fashionWingId, false);
		this.writeInt(buf, huanwu, false);
		return true;
	}
}
