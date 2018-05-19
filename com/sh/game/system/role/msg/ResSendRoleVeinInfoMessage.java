package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.role.msg.bean.VeinBean;

/**
 * <p>发送角色经脉信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendRoleVeinInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendRoleVeinInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8026;
	}
	
	/**
	 * 角色经脉信息
	 */
	private VeinBean roleVein;

	public VeinBean getRoleVein() {
		return roleVein;
	}

	public void setRoleVein(VeinBean roleVein) {
		this.roleVein = roleVein;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			VeinBean veinBean = new VeinBean();
			veinBean.read(buf);
			this.roleVein = veinBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, roleVein);
		return true;
	}
}
