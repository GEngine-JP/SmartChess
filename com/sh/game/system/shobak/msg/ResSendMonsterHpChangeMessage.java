package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.shobak.msg.bean.MonsterInfoBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>守卫和雕像的血量变化</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendMonsterHpChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendMonsterHpChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40015;
	}
	
	/**
	 * 怪物信息
	 */
	private List<MonsterInfoBean> monsterInfos = new ArrayList<MonsterInfoBean>();


	public List<MonsterInfoBean> getMonsterInfos() {
		return monsterInfos;
	}

	public void setMonsterInfos(List<MonsterInfoBean> monsterInfos) {
		this.monsterInfos = monsterInfos;
	}


	@Override
	public boolean read(KryoInput buf) {
		int monsterInfosLength = readShort(buf);
		for (int monsterInfosI = 0; monsterInfosI < monsterInfosLength; monsterInfosI++) {
			if (readByte(buf) == 0) { 
				this.monsterInfos.add(null);
			} else {
				MonsterInfoBean monsterInfoBean = new MonsterInfoBean();
				monsterInfoBean.read(buf);
				this.monsterInfos.add(monsterInfoBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.monsterInfos.size());
		for (int monsterInfosI = 0; monsterInfosI < this.monsterInfos.size(); monsterInfosI++) {
			this.writeBean(buf, this.monsterInfos.get(monsterInfosI));
		}


		return true;
	}
}

