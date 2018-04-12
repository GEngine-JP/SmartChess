package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.shobak.msg.bean.AttackInfoBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送攻击雕像和守卫信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendAttackStatusInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendAttackStatusInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40018;
	}
	
	/**
	 * 攻击信息
	 */
	private List<AttackInfoBean> attackInfos = new ArrayList<AttackInfoBean>();


	public List<AttackInfoBean> getAttackInfos() {
		return attackInfos;
	}

	public void setAttackInfos(List<AttackInfoBean> attackInfos) {
		this.attackInfos = attackInfos;
	}


	@Override
	public boolean read(KryoInput buf) {
		int attackInfosLength = readShort(buf);
		for (int attackInfosI = 0; attackInfosI < attackInfosLength; attackInfosI++) {
			if (readByte(buf) == 0) { 
				this.attackInfos.add(null);
			} else {
				AttackInfoBean attackInfoBean = new AttackInfoBean();
				attackInfoBean.read(buf);
				this.attackInfos.add(attackInfoBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.attackInfos.size());
		for (int attackInfosI = 0; attackInfosI < this.attackInfos.size(); attackInfosI++) {
			this.writeBean(buf, this.attackInfos.get(attackInfosI));
		}


		return true;
	}
}

