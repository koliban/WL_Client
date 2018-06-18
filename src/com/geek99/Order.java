package com.geek99;

import java.util.List;

public class Order {
//	`id` int(11) NOT NULL AUTO_INCREMENT,
//	  `ctime` varchar(20) DEFAULT NULL,
//	  `uid` int(11) DEFAULT NULL,
//	  `tid` int(11) DEFAULT NULL,
//	  `description` varchar(20) DEFAULT NULL,
//	  `personNum` int(11) DEFAULT NULL,
	String ctime;
	int uid;
	int tid;
	String desc;
	int personNum;
	List<MenuTemp> list;
	
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPersonNum() {
		return personNum;
	}
	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	public List<MenuTemp> getList() {
		return list;
	}
	public void setList(List<MenuTemp> list) {
		this.list = list;
	}
	
}
