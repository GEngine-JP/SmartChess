package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.hero.msg.bean.VeinBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送所以英雄经脉信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendHeroAllInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendHeroAllInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22013;
	}
	
	/**
	 * 所有英雄的经脉信息
	 */
	private List<VeinBean> heroVeins = new ArrayList<VeinBean>();


	public List<VeinBean> getHeroVeins() {
		return heroVeins;
	}

	public void setHeroVeins(List<VeinBean> heroVeins) {
		this.heroVeins = heroVeins;
	}


	@Override
	public boolean read(KryoInput buf) {
		int heroVeinsLength = readShort(buf);
		for (int heroVeinsI = 0; heroVeinsI < heroVeinsLength; heroVeinsI++) {
			if (readByte(buf) == 0) { 
				this.heroVeins.add(null);
			} else {
				VeinBean veinBean = new VeinBean();
				veinBean.read(buf);
				this.heroVeins.add(veinBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.heroVeins.size());
		for (int heroVeinsI = 0; heroVeinsI < this.heroVeins.size(); heroVeinsI++) {
			this.writeBean(buf, this.heroVeins.get(heroVeinsI));
		}


		return true;
	}
}

