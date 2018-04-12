package com.sh.game.system.chat.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;

import com.sh.game.system.chat.msg.bean.AttributeBean;
import com.sh.game.system.chat.msg.bean.EquipItemBean;
import com.sh.game.system.chat.msg.bean.ShenZhuangBean;
import com.sh.game.system.chat.msg.bean.LingBaoBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class RoleInfoBean extends KryoBean {

	/**
	 * 翅膀id
	 */
	private int windId;

	/**
	 * 性别
	 */
	private int sex;

	/**
	 * 职业
	 */
	private int career;

	/**
	 * 转生
	 */
	private int rein;

	/**
	 * 等级
	 */
	private int level;

	/**
	 * 神弓
	 */
	private int xueyu;

	/**
	 * 神斧
	 */
	private int shengdun;

	/**
	 * 神剑
	 */
	private int guanyin;

	/**
	 * 法宝
	 */
	private int longhun;

	/**
	 * 玩家名字
	 */
	private String name;

	/**
	 * 行会
	 */
	private String unionName;

	/**
	 * 称号
	 */
	private int fashionTitle;

	/**
	 * 衣服
	 */
	private int fashionCloth;

	/**
	 * 武器
	 */
	private int fashionWeapon;

	/**
	 * 翅膀
	 */
	private int fashionWing;

	/**
	 * 战力
	 */
	private int fightPower;

	/**
	 * 玩家基本属性
	 */
	private AttributeBean playerAttribute;

	/**
	 * 装备列表
	 */
	private List<EquipItemBean> equipItemBeanList = new ArrayList<EquipItemBean>();

	/**
	 * 强化列表
	 */
	private List<Integer> strengthList = new ArrayList<Integer>();

	/**
	 * 神装列表
	 */
	private List<ShenZhuangBean> szList = new ArrayList<ShenZhuangBean>();

	/**
	 * 神装战力
	 */
	private int szFightPower;

	/**
	 * 神装套装
	 */
	private int szSuit;

	/**
	 * 神装数量
	 */
	private int szCount;

	/**
	 * 灵宝列表
	 */
	private List<LingBaoBean> lbList = new ArrayList<LingBaoBean>();


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

	
	public int getRein() {
		return rein;
	}

	public void setRein(int rein) {
		this.rein = rein;
	}

	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	public int getXueyu() {
		return xueyu;
	}

	public void setXueyu(int xueyu) {
		this.xueyu = xueyu;
	}

	
	public int getShengdun() {
		return shengdun;
	}

	public void setShengdun(int shengdun) {
		this.shengdun = shengdun;
	}

	
	public int getGuanyin() {
		return guanyin;
	}

	public void setGuanyin(int guanyin) {
		this.guanyin = guanyin;
	}

	
	public int getLonghun() {
		return longhun;
	}

	public void setLonghun(int longhun) {
		this.longhun = longhun;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
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

	
	public int getFashionWeapon() {
		return fashionWeapon;
	}

	public void setFashionWeapon(int fashionWeapon) {
		this.fashionWeapon = fashionWeapon;
	}

	
	public int getFashionWing() {
		return fashionWing;
	}

	public void setFashionWing(int fashionWing) {
		this.fashionWing = fashionWing;
	}

	
	public int getFightPower() {
		return fightPower;
	}

	public void setFightPower(int fightPower) {
		this.fightPower = fightPower;
	}

	
	public AttributeBean getPlayerAttribute() {
		return playerAttribute;
	}

	public void setPlayerAttribute(AttributeBean playerAttribute) {
		this.playerAttribute = playerAttribute;
	}

	
	public List<EquipItemBean> getEquipItemBeanList() {
		return equipItemBeanList;
	}

	public void setEquipItemBeanList(List<EquipItemBean> equipItemBeanList) {
		this.equipItemBeanList = equipItemBeanList;
	}

	public List<Integer> getStrengthList() {
		return strengthList;
	}

	public void setStrengthList(List<Integer> strengthList) {
		this.strengthList = strengthList;
	}

	public List<ShenZhuangBean> getSzList() {
		return szList;
	}

	public void setSzList(List<ShenZhuangBean> szList) {
		this.szList = szList;
	}

	public int getSzFightPower() {
		return szFightPower;
	}

	public void setSzFightPower(int szFightPower) {
		this.szFightPower = szFightPower;
	}

	
	public int getSzSuit() {
		return szSuit;
	}

	public void setSzSuit(int szSuit) {
		this.szSuit = szSuit;
	}

	
	public int getSzCount() {
		return szCount;
	}

	public void setSzCount(int szCount) {
		this.szCount = szCount;
	}

	
	public List<LingBaoBean> getLbList() {
		return lbList;
	}

	public void setLbList(List<LingBaoBean> lbList) {
		this.lbList = lbList;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.windId = readInt(buf, false);
		this.sex = readInt(buf, false);
		this.career = readInt(buf, false);
		this.rein = readInt(buf, false);
		this.level = readInt(buf, false);
		this.xueyu = readInt(buf, false);
		this.shengdun = readInt(buf, false);
		this.guanyin = readInt(buf, false);
		this.longhun = readInt(buf, false);
		this.name = readString(buf);
		this.unionName = readString(buf);
		this.fashionTitle = readInt(buf, false);
		this.fashionCloth = readInt(buf, false);
		this.fashionWeapon = readInt(buf, false);
		this.fashionWing = readInt(buf, false);
		this.fightPower = readInt(buf, false);
		if (readByte(buf) != 0) {
			AttributeBean attributeBean = new AttributeBean();
			attributeBean.read(buf);
			this.playerAttribute = attributeBean;
		}
		int equipItemBeanListLength = readShort(buf);
		for (int equipItemBeanListI = 0; equipItemBeanListI < equipItemBeanListLength; equipItemBeanListI++) {
			if (readByte(buf) == 0) { 
				this.equipItemBeanList.add(null);
			} else {
				EquipItemBean equipItemBean = new EquipItemBean();
				equipItemBean.read(buf);
				this.equipItemBeanList.add(equipItemBean);
			}
		}

		int strengthListLength = readShort(buf);
		for (int strengthListI = 0; strengthListI < strengthListLength; strengthListI++) {
			this.strengthList.add(this.readInt(buf, false));
		}

		int szListLength = readShort(buf);
		for (int szListI = 0; szListI < szListLength; szListI++) {
			if (readByte(buf) == 0) { 
				this.szList.add(null);
			} else {
				ShenZhuangBean shenZhuangBean = new ShenZhuangBean();
				shenZhuangBean.read(buf);
				this.szList.add(shenZhuangBean);
			}
		}

		this.szFightPower = readInt(buf, false);
		this.szSuit = readInt(buf, false);
		this.szCount = readInt(buf, false);
		int lbListLength = readShort(buf);
		for (int lbListI = 0; lbListI < lbListLength; lbListI++) {
			if (readByte(buf) == 0) { 
				this.lbList.add(null);
			} else {
				LingBaoBean lingBaoBean = new LingBaoBean();
				lingBaoBean.read(buf);
				this.lbList.add(lingBaoBean);
			}
		}


		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, windId, false);
		this.writeInt(buf, sex, false);
		this.writeInt(buf, career, false);
		this.writeInt(buf, rein, false);
		this.writeInt(buf, level, false);
		this.writeInt(buf, xueyu, false);
		this.writeInt(buf, shengdun, false);
		this.writeInt(buf, guanyin, false);
		this.writeInt(buf, longhun, false);
		this.writeString(buf, name);
		this.writeString(buf, unionName);
		this.writeInt(buf, fashionTitle, false);
		this.writeInt(buf, fashionCloth, false);
		this.writeInt(buf, fashionWeapon, false);
		this.writeInt(buf, fashionWing, false);
		this.writeInt(buf, fightPower, false);
		this.writeBean(buf, playerAttribute);
		writeShort(buf, this.equipItemBeanList.size());
		for (int equipItemBeanListI = 0; equipItemBeanListI < this.equipItemBeanList.size(); equipItemBeanListI++) {
			this.writeBean(buf, this.equipItemBeanList.get(equipItemBeanListI));
		}

		writeShort(buf, this.strengthList.size());
		for (int strengthListI = 0; strengthListI < this.strengthList.size(); strengthListI++) {
			this.writeInt(buf, this.strengthList.get(strengthListI), false);
		}

		writeShort(buf, this.szList.size());
		for (int szListI = 0; szListI < this.szList.size(); szListI++) {
			this.writeBean(buf, this.szList.get(szListI));
		}

		this.writeInt(buf, szFightPower, false);
		this.writeInt(buf, szSuit, false);
		this.writeInt(buf, szCount, false);
		writeShort(buf, this.lbList.size());
		for (int lbListI = 0; lbListI < this.lbList.size(); lbListI++) {
			this.writeBean(buf, this.lbList.get(lbListI));
		}


		return true;
	}
}

