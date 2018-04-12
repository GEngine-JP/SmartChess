package com.sh.game.system.wing.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.wing.msg.bean.WingEquipBean;


/**
 * <p>返回激活光翼装备</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResActivateWingEquipMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResActivateWingEquipMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 18008;
	}
	
	/**
	 * 1角色光翼 2英雄光翼
	 */
	private int type;

	/**
	 * 英雄id
	 */
	private long heroId;

	/**
	 * 光翼装备
	 */
	private WingEquipBean wingEquipBean;


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

	
	public WingEquipBean getWingEquipBean() {
		return wingEquipBean;
	}

	public void setWingEquipBean(WingEquipBean wingEquipBean) {
		this.wingEquipBean = wingEquipBean;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		if (readByte(buf) != 0) {
			WingEquipBean wingEquipBean = new WingEquipBean();
			wingEquipBean.read(buf);
			this.wingEquipBean = wingEquipBean;
		}

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeBean(buf, wingEquipBean);

		return true;
	}
}

