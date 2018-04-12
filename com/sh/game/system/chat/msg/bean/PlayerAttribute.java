package com.sh.game.system.chat.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class PlayerAttribute extends KryoBean {

	/**
	 * 血量最大值
	 */
	private int hpMax;

	/**
	 * 攻击
	 */
	private int attack;

	/**
	 * 物理防御
	 */
	private int phyDefence;

	/**
	 * 物理防御比例
	 */
	private int phyDefenceRate;

	/**
	 * 魔法防御
	 */
	private int magicDefence;

	/**
	 * 魔法防御比例
	 */
	private int magicDefenceRate;

	/**
	 * 暴击值
	 */
	private int critical;

	/**
	 * 暴击概率
	 */
	private int criticalRate;

	/**
	 * 暴击固定伤害
	 */
	private int critFix;

	/**
	 * 暴击抗性（韧性）
	 */
	private int critResist;

	/**
	 * 暴击抗性（韧性）概率
	 */
	private int critResistRate;

	/**
	 * 当前血量
	 */
	private int hp;

	/**
	 * 当前内力
	 */
	private int innerPower;

	/**
	 * 对战士伤害增加
	 */
	private int zsHurtAdd;

	/**
	 * 受战士伤害减少
	 */
	private int zsHurtedRelief;

	/**
	 * 对法师伤害增加
	 */
	private int fsHurtAdd;

	/**
	 * 受法师伤害减少
	 */
	private int fsHurtedRelief;

	/**
	 * 对道士伤害增加
	 */
	private int dsHurtAdd;

	/**
	 * 受道士伤害减少
	 */
	private int dsHurtedRelief;

	/**
	 * 对英雄伤害增加
	 */
	private int heroHurtAdd;

	/**
	 * 受英雄伤害减少
	 */
	private int heroHurtedRelief;

	/**
	 * 对怪物伤害增加
	 */
	private int monHurtAdd;

	/**
	 * 受怪物伤害减免
	 */
	private int monHurtedRelief;

	/**
	 * 对怪物暴击概率
	 */
	private int monCritical;

	/**
	 * 对怪物暴击伤害
	 */
	private int monCritFix;

	/**
	 * 免伤
	 */
	private int relief;


	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	
	public int getPhyDefence() {
		return phyDefence;
	}

	public void setPhyDefence(int phyDefence) {
		this.phyDefence = phyDefence;
	}

	
	public int getPhyDefenceRate() {
		return phyDefenceRate;
	}

	public void setPhyDefenceRate(int phyDefenceRate) {
		this.phyDefenceRate = phyDefenceRate;
	}

	
	public int getMagicDefence() {
		return magicDefence;
	}

	public void setMagicDefence(int magicDefence) {
		this.magicDefence = magicDefence;
	}

	
	public int getMagicDefenceRate() {
		return magicDefenceRate;
	}

	public void setMagicDefenceRate(int magicDefenceRate) {
		this.magicDefenceRate = magicDefenceRate;
	}

	
	public int getCritical() {
		return critical;
	}

	public void setCritical(int critical) {
		this.critical = critical;
	}

	
	public int getCriticalRate() {
		return criticalRate;
	}

	public void setCriticalRate(int criticalRate) {
		this.criticalRate = criticalRate;
	}

	
	public int getCritFix() {
		return critFix;
	}

	public void setCritFix(int critFix) {
		this.critFix = critFix;
	}

	
	public int getCritResist() {
		return critResist;
	}

	public void setCritResist(int critResist) {
		this.critResist = critResist;
	}

	
	public int getCritResistRate() {
		return critResistRate;
	}

	public void setCritResistRate(int critResistRate) {
		this.critResistRate = critResistRate;
	}

	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	
	public int getInnerPower() {
		return innerPower;
	}

	public void setInnerPower(int innerPower) {
		this.innerPower = innerPower;
	}

	
	public int getZsHurtAdd() {
		return zsHurtAdd;
	}

	public void setZsHurtAdd(int zsHurtAdd) {
		this.zsHurtAdd = zsHurtAdd;
	}

	
	public int getZsHurtedRelief() {
		return zsHurtedRelief;
	}

	public void setZsHurtedRelief(int zsHurtedRelief) {
		this.zsHurtedRelief = zsHurtedRelief;
	}

	
	public int getFsHurtAdd() {
		return fsHurtAdd;
	}

	public void setFsHurtAdd(int fsHurtAdd) {
		this.fsHurtAdd = fsHurtAdd;
	}

	
	public int getFsHurtedRelief() {
		return fsHurtedRelief;
	}

	public void setFsHurtedRelief(int fsHurtedRelief) {
		this.fsHurtedRelief = fsHurtedRelief;
	}

	
	public int getDsHurtAdd() {
		return dsHurtAdd;
	}

	public void setDsHurtAdd(int dsHurtAdd) {
		this.dsHurtAdd = dsHurtAdd;
	}

	
	public int getDsHurtedRelief() {
		return dsHurtedRelief;
	}

	public void setDsHurtedRelief(int dsHurtedRelief) {
		this.dsHurtedRelief = dsHurtedRelief;
	}

	
	public int getHeroHurtAdd() {
		return heroHurtAdd;
	}

	public void setHeroHurtAdd(int heroHurtAdd) {
		this.heroHurtAdd = heroHurtAdd;
	}

	
	public int getHeroHurtedRelief() {
		return heroHurtedRelief;
	}

	public void setHeroHurtedRelief(int heroHurtedRelief) {
		this.heroHurtedRelief = heroHurtedRelief;
	}

	
	public int getMonHurtAdd() {
		return monHurtAdd;
	}

	public void setMonHurtAdd(int monHurtAdd) {
		this.monHurtAdd = monHurtAdd;
	}

	
	public int getMonHurtedRelief() {
		return monHurtedRelief;
	}

	public void setMonHurtedRelief(int monHurtedRelief) {
		this.monHurtedRelief = monHurtedRelief;
	}

	
	public int getMonCritical() {
		return monCritical;
	}

	public void setMonCritical(int monCritical) {
		this.monCritical = monCritical;
	}

	
	public int getMonCritFix() {
		return monCritFix;
	}

	public void setMonCritFix(int monCritFix) {
		this.monCritFix = monCritFix;
	}

	
	public int getRelief() {
		return relief;
	}

	public void setRelief(int relief) {
		this.relief = relief;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.hpMax = readInt(buf, false);
		this.attack = readInt(buf, false);
		this.phyDefence = readInt(buf, false);
		this.phyDefenceRate = readInt(buf, false);
		this.magicDefence = readInt(buf, false);
		this.magicDefenceRate = readInt(buf, false);
		this.critical = readInt(buf, false);
		this.criticalRate = readInt(buf, false);
		this.critFix = readInt(buf, false);
		this.critResist = readInt(buf, false);
		this.critResistRate = readInt(buf, false);
		this.hp = readInt(buf, false);
		this.innerPower = readInt(buf, false);
		this.zsHurtAdd = readInt(buf, false);
		this.zsHurtedRelief = readInt(buf, false);
		this.fsHurtAdd = readInt(buf, false);
		this.fsHurtedRelief = readInt(buf, false);
		this.dsHurtAdd = readInt(buf, false);
		this.dsHurtedRelief = readInt(buf, false);
		this.heroHurtAdd = readInt(buf, false);
		this.heroHurtedRelief = readInt(buf, false);
		this.monHurtAdd = readInt(buf, false);
		this.monHurtedRelief = readInt(buf, false);
		this.monCritical = readInt(buf, false);
		this.monCritFix = readInt(buf, false);
		this.relief = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, hpMax, false);
		this.writeInt(buf, attack, false);
		this.writeInt(buf, phyDefence, false);
		this.writeInt(buf, phyDefenceRate, false);
		this.writeInt(buf, magicDefence, false);
		this.writeInt(buf, magicDefenceRate, false);
		this.writeInt(buf, critical, false);
		this.writeInt(buf, criticalRate, false);
		this.writeInt(buf, critFix, false);
		this.writeInt(buf, critResist, false);
		this.writeInt(buf, critResistRate, false);
		this.writeInt(buf, hp, false);
		this.writeInt(buf, innerPower, false);
		this.writeInt(buf, zsHurtAdd, false);
		this.writeInt(buf, zsHurtedRelief, false);
		this.writeInt(buf, fsHurtAdd, false);
		this.writeInt(buf, fsHurtedRelief, false);
		this.writeInt(buf, dsHurtAdd, false);
		this.writeInt(buf, dsHurtedRelief, false);
		this.writeInt(buf, heroHurtAdd, false);
		this.writeInt(buf, heroHurtedRelief, false);
		this.writeInt(buf, monHurtAdd, false);
		this.writeInt(buf, monHurtedRelief, false);
		this.writeInt(buf, monCritical, false);
		this.writeInt(buf, monCritFix, false);
		this.writeInt(buf, relief, false);

		return true;
	}
}

