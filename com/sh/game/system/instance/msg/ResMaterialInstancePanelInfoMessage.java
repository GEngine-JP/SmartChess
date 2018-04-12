package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.instance.msg.bean.MaterialInfo;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送材料副本面板信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResMaterialInstancePanelInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResMaterialInstancePanelInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20015;
	}
	
	/**
	 * 材料副本信息
	 */
	private List<MaterialInfo> infos = new ArrayList<MaterialInfo>();


	public List<MaterialInfo> getInfos() {
		return infos;
	}

	public void setInfos(List<MaterialInfo> infos) {
		this.infos = infos;
	}


	@Override
	public boolean read(KryoInput buf) {
		int infosLength = readShort(buf);
		for (int infosI = 0; infosI < infosLength; infosI++) {
			if (readByte(buf) == 0) { 
				this.infos.add(null);
			} else {
				MaterialInfo materialInfo = new MaterialInfo();
				materialInfo.read(buf);
				this.infos.add(materialInfo);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.infos.size());
		for (int infosI = 0; infosI < this.infos.size(); infosI++) {
			this.writeBean(buf, this.infos.get(infosI));
		}


		return true;
	}
}

