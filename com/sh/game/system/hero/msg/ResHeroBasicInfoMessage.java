package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.hero.msg.bean.HerosAttributeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>英雄基本数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHeroBasicInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroBasicInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22001;
	}
	
	/**
	 * 英雄信息
	 */
	private List<HerosAttributeBean> heroInfo = new ArrayList<>();

	public List<HerosAttributeBean> getHeroInfo() {
		return heroInfo;
	}

	public void setHeroInfo(List<HerosAttributeBean> heroInfo) {
		this.heroInfo = heroInfo;
	}

	@Override
	public boolean read(KryoInput buf) {

		int heroInfoLength = readShort(buf);
		for (int heroInfoI = 0; heroInfoI < heroInfoLength; heroInfoI++) {
			if (readByte(buf) == 0) { 
				this.heroInfo.add(null);
			} else {
				HerosAttributeBean herosAttributeBean = new HerosAttributeBean();
				herosAttributeBean.read(buf);
				this.heroInfo.add(herosAttributeBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.heroInfo.size());
		for (int heroInfoI = 0; heroInfoI < this.heroInfo.size(); heroInfoI++) {
			this.writeBean(buf, this.heroInfo.get(heroInfoI));
		}
		return true;
	}
}
