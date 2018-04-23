package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送沙巴克战斗结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendShobakFightResultMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendShobakFightResultMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40014;
	}
	
	/**
	 * 获胜者id
	 */
	private long winner;
	/**
	 * 失败者id
	 */
	private long loser;
	/**
	 * 获胜者剩余血量
	 */
	private long hp;

	public long getWinner() {
		return winner;
	}

	public void setWinner(long winner) {
		this.winner = winner;
	}

		public long getLoser() {
		return loser;
	}

	public void setLoser(long loser) {
		this.loser = loser;
	}

		public long getHp() {
		return hp;
	}

	public void setHp(long hp) {
		this.hp = hp;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.winner = readLong(buf);
		this.loser = readLong(buf);
		this.hp = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, winner);
		this.writeLong(buf, loser);
		this.writeLong(buf, hp);
		return true;
	}
}
