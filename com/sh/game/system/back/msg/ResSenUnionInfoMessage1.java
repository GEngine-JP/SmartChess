package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.back.msg.bean.UnionMemberInfoBean1;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>后台查看帮会数据</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSenUnionInfoMessage1 extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSenUnionInfoMessage1() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43046;
	}
	
	/**
	 * 帮会名称
	 */
	private String unionName;

	/**
	 * 帮会成员列表
	 */
	private List<UnionMemberInfoBean1> memberList = new ArrayList<UnionMemberInfoBean1>();


	public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}

	
	public List<UnionMemberInfoBean1> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<UnionMemberInfoBean1> memberList) {
		this.memberList = memberList;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.unionName = readString(buf);
		int memberListLength = readShort(buf);
		for (int memberListI = 0; memberListI < memberListLength; memberListI++) {
			if (readByte(buf) == 0) { 
				this.memberList.add(null);
			} else {
				UnionMemberInfoBean1 unionMemberInfoBean1 = new UnionMemberInfoBean1();
				unionMemberInfoBean1.read(buf);
				this.memberList.add(unionMemberInfoBean1);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, unionName);
		writeShort(buf, this.memberList.size());
		for (int memberListI = 0; memberListI < this.memberList.size(); memberListI++) {
			this.writeBean(buf, this.memberList.get(memberListI));
		}


		return true;
	}
}

