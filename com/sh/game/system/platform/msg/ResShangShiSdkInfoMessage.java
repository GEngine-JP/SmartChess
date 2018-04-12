package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回上士sdk参数信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResShangShiSdkInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResShangShiSdkInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44002;
	}
	
	/**
	 * 订单号
	 */
	private String cp_trade_sn;

	/**
	 * 充值金额
	 */
	private int money;

	/**
	 * 玩家等级
	 */
	private int level;

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

	/**
	 * 加密串
	 */
	private String sign;


	public String getCp_trade_sn() {
		return cp_trade_sn;
	}

	public void setCp_trade_sn(String cp_trade_sn) {
		this.cp_trade_sn = cp_trade_sn;
	}

	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.cp_trade_sn = readString(buf);
		this.money = readInt(buf, false);
		this.level = readInt(buf, false);
		this.money_type = readString(buf);
		this.goods_id = readString(buf);
		this.time = readInt(buf, false);
		this.sign = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, cp_trade_sn);
		this.writeInt(buf, money, false);
		this.writeInt(buf, level, false);
		this.writeString(buf, money_type);
		this.writeString(buf, goods_id);
		this.writeInt(buf, time, false);
		this.writeString(buf, sign);

		return true;
	}
}

