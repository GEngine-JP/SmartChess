package com.sh.game.system.chapter.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ChapterRankBean extends KryoBean {

	/**
	 * 关卡
	 */
	private int chapter;

	/**
	 * 玩家名
	 */
	private String name;


	public int getChapter() {
		return chapter;
	}

	public void setChapter(int chapter) {
		this.chapter = chapter;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.chapter = readInt(buf, false);
		this.name = readString(buf);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, chapter, false);
		this.writeString(buf, name);

		return true;
	}
}

