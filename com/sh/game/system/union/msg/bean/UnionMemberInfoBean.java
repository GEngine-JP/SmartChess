package com.sh.game.system.union.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class UnionMemberInfoBean extends KryoBean {

	/**
	 * 玩家id
	 */
	private long id;

	/**
	 * 成员名称
	 */
	private String memberName;

	/**
	 * 成员职位 3会长 2副会长 0成员
	 */
	private int position;

	/**
	 * 成员职业
	 */
	private int career;

	/**
	 * 成员等级
	 */
	private int memberLevel;

	/**
	 * 成员离线时间
	 */
	private long offlineTime;

	/**
	 * 战力
	 */
	private int fightPower;

	/**
	 * 历史贡献
	 */
	private long contributionHistory;

	/**
	 * 性别
	 */
	private int sex;

	/**
	 * 衣服
	 */
	private int cloth;

	/**
	 * 武器
	 */
	private int weapon;

	/**
	 * 翅膀
	 */
	private int wing;

	/**
	 * 称号
	 */
	private int fashionTitle;

	/**
	 * 衣服
	 */
	private int fashionCloth;

	/**
	 * 翅膀
	 */
	private int fashionWing;

	/**
	 * 武器
	 */
	private int fashionWeapon;

	/**
	 * vip等级
	 */
	private int vipLevel;

	/**
	 * 是否有月卡
	 */
	private boolean isMonthCard;

	/**
	 * 穿戴的寶物id
	 */
	private int treasure;

	/**
	 * 激活的神装套装id
	 */
	private int szSuitId;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	
	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	
	public int getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}

	
	public long getOfflineTime() {
		return offlineTime;
	}

	public void setOfflineTime(long offlineTime) {
		this.offlineTime = offlineTime;
	}

	
	public int getFightPower() {
		return fightPower;
	}

	public void setFightPower(int fightPower) {
		this.fightPower = fightPower;
	}

	
	public long getContributionHistory() {
		return contributionHistory;
	}

	public void setContributionHistory(long contributionHistory) {
		this.contributionHistory = contributionHistory;
	}

	
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	
	public int getCloth() {
		return cloth;
	}

	public void setCloth(int cloth) {
		this.cloth = cloth;
	}

	
	public int getWeapon() {
		return weapon;
	}

	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}

	
	public int getWing() {
		return wing;
	}

	public void setWing(int wing) {
		this.wing = wing;
	}

	
	public int getFashionTitle() {
		return fashionTitle;
	}

	public void setFashionTitle(int fashionTitle) {
		this.fashionTitle = fashionTitle;
	}

	
	public int getFashionCloth() {
		return fashionCloth;
	}

	public void setFashionCloth(int fashionCloth) {
		this.fashionCloth = fashionCloth;
	}

	
	public int getFashionWing() {
		return fashionWing;
	}

	public void setFashionWing(int fashionWing) {
		this.fashionWing = fashionWing;
	}

	
	public int getFashionWeapon() {
		return fashionWeapon;
	}

	public void setFashionWeapon(int fashionWeapon) {
		this.fashionWeapon = fashionWeapon;
	}

	
	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	
	public boolean getIsMonthCard() {
		return isMonthCard;
	}

	public void setIsMonthCard(boolean isMonthCard) {
		this.isMonthCard = isMonthCard;
	}

	
	public int getTreasure() {
		return treasure;
	}

	public void setTreasure(int treasure) {
		this.treasure = treasure;
	}

	
	public int getSzSuitId() {
		return szSuitId;
	}

	public void setSzSuitId(int szSuitId) {
		this.szSuitId = szSuitId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.id = readLong(buf);
		this.memberName = readString(buf);
		this.position = readInt(buf, false);
		this.career = readInt(buf, false);
		this.memberLevel = readInt(buf, false);
		this.offlineTime = readLong(buf);
		this.fightPower = readInt(buf, false);
		this.contributionHistory = readLong(buf);
		this.sex = readInt(buf, false);
		this.cloth = readInt(buf, false);
		this.weapon = readInt(buf, false);
		this.wing = readInt(buf, false);
		this.fashionTitle = readInt(buf, false);
		this.fashionCloth = readInt(buf, false);
		this.fashionWing = readInt(buf, false);
		this.fashionWeapon = readInt(buf, false);
		this.vipLevel = readInt(buf, false);
		this.isMonthCard = readBoolean(buf);
		this.treasure = readInt(buf, false);
		this.szSuitId = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, id);
		this.writeString(buf, memberName);
		this.writeInt(buf, position, false);
		this.writeInt(buf, career, false);
		this.writeInt(buf, memberLevel, false);
		this.writeLong(buf, offlineTime);
		this.writeInt(buf, fightPower, false);
		this.writeLong(buf, contributionHistory);
		this.writeInt(buf, sex, false);
		this.writeInt(buf, cloth, false);
		this.writeInt(buf, weapon, false);
		this.writeInt(buf, wing, false);
		this.writeInt(buf, fashionTitle, false);
		this.writeInt(buf, fashionCloth, false);
		this.writeInt(buf, fashionWing, false);
		this.writeInt(buf, fashionWeapon, false);
		this.writeInt(buf, vipLevel, false);
		this.writeBoolean(buf, isMonthCard);
		this.writeInt(buf, treasure, false);
		this.writeInt(buf, szSuitId, false);

		return true;
	}
}

