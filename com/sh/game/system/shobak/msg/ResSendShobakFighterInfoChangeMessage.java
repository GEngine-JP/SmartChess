package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.shobak.msg.bean.ShobakTeamMemberBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送沙巴克战斗者的信息(进入地图)</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendShobakFighterInfoChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendShobakFighterInfoChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40006;
	}
	
	/**
	 * 玩家信息
	 */
	private List<ShobakTeamMemberBean> infoBeans = new ArrayList<ShobakTeamMemberBean>();


	public List<ShobakTeamMemberBean> getInfoBeans() {
		return infoBeans;
	}

	public void setInfoBeans(List<ShobakTeamMemberBean> infoBeans) {
		this.infoBeans = infoBeans;
	}


	@Override
	public boolean read(KryoInput buf) {
		int infoBeansLength = readShort(buf);
		for (int infoBeansI = 0; infoBeansI < infoBeansLength; infoBeansI++) {
			if (readByte(buf) == 0) { 
				this.infoBeans.add(null);
			} else {
				ShobakTeamMemberBean shobakTeamMemberBean = new ShobakTeamMemberBean();
				shobakTeamMemberBean.read(buf);
				this.infoBeans.add(shobakTeamMemberBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.infoBeans.size());
		for (int infoBeansI = 0; infoBeansI < this.infoBeans.size(); infoBeansI++) {
			this.writeBean(buf, this.infoBeans.get(infoBeansI));
		}


		return true;
	}
}

