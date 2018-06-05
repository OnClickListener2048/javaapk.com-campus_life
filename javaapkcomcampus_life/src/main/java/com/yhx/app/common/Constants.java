/**
 * 
 */
package com.yhx.app.common;

/**
 * @author yhx
 *
 */
public class Constants {
	/** 与服务器端连接的协议名 */
	public static final String PROTOCOL = "http://";
	/** 服务器IP */
	//public static final String HOST = "192.168.1.124";//AVD test
//	public static final String HOST = "127.0.0.1";//AVD test 192.168.191.1
//	public static final String HOST = "10.0.2.2";//模拟器测试地址，若是真机，则要换成电脑主机地址
	public static final String HOST = "192.168.170.2";//模拟器测试地址，若是真机，则要换成电脑主机地址
	/** 服务器端口号 */
	public static final String PORT = "8080";
	public static final String URL = PROTOCOL+HOST+":"+PORT;

	/**
	 * 个人求职者
	 */
	public static final int INDIVIDUAL = 0;
	/**
	 * 职位发布者
	 */
	public static final int GROUP = 1;
}
