package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>疯狂订单号</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResCrazyOrderMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCrazyOrderMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44007;
	}
	
	/**
	 * 订单号
	 */
	private String order_id;
	/**
	 * appid
	 */
	private String app_id;
	/**
	 * 时间
	 */
	private String timestamp;
	/**
	 * nonce_str
	 */
	private String nonce_str;
	/**
	 * package
	 */
	private String packageStr;
	/**
	 * sign_type
	 */
	private String sign_type;
	/**
	 * pay_sign
	 */
	private String pay_sign;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

		public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

		public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

		public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

		public String getPackageStr() {
		return packageStr;
	}

	public void setPackageStr(String packageStr) {
		this.packageStr = packageStr;
	}

		public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

		public String getPay_sign() {
		return pay_sign;
	}

	public void setPay_sign(String pay_sign) {
		this.pay_sign = pay_sign;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.order_id = readString(buf);
		this.app_id = readString(buf);
		this.timestamp = readString(buf);
		this.nonce_str = readString(buf);
		this.packageStr = readString(buf);
		this.sign_type = readString(buf);
		this.pay_sign = readString(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeString(buf, order_id);
		this.writeString(buf, app_id);
		this.writeString(buf, timestamp);
		this.writeString(buf, nonce_str);
		this.writeString(buf, packageStr);
		this.writeString(buf, sign_type);
		this.writeString(buf, pay_sign);
		return true;
	}
}
