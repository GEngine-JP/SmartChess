package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.role.msg.bean.PetBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送宠物列表</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResPetListMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResPetListMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8012;
	}
	
	/**
	 * 宠物列表
	 */
	private List<PetBean> petBean = new ArrayList<PetBean>();


	public List<PetBean> getPetBean() {
		return petBean;
	}

	public void setPetBean(List<PetBean> petBean) {
		this.petBean = petBean;
	}


	@Override
	public boolean read(KryoInput buf) {
		int petBeanLength = readShort(buf);
		for (int petBeanI = 0; petBeanI < petBeanLength; petBeanI++) {
			if (readByte(buf) == 0) { 
				this.petBean.add(null);
			} else {
				PetBean petBean = new PetBean();
				petBean.read(buf);
				this.petBean.add(petBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.petBean.size());
		for (int petBeanI = 0; petBeanI < this.petBean.size(); petBeanI++) {
			this.writeBean(buf, this.petBean.get(petBeanI));
		}


		return true;
	}
}

