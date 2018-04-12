package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求上士sdk参数信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqShangShiSdkInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqShangShiSdkInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44001;
	}
	
	/**
	 * 充值金额
	 */
	private int money;

	/**
	 * 货币类型
	 */
	private String money_type;

	/**
	 * 商品id
	 */
	private String goods_id;

	/**
	 * 时间
	 */
	private int time;


	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	
	public String getMoney_type() {
		return money_type;
	}

	public void setMoney_type(String money_type) {
		this.money_type = money_type;
	}

	
	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.money = readInt(buf, false);
		this.money_type = readString(buf);
		this.goods_id = readString(buf);
		this.time = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, money, false);
		this.writeString(buf, money_type);
		this.writeString(buf, goods_id);
		this.writeInt(buf, time, false);

		return true;
	}
}

