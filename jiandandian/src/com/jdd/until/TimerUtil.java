package com.jdd.until;
/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-19  下午6:25:37
 */
public class TimerUtil {
	private static long start;
	private static long end;
	public static void start(){
		start=System.currentTimeMillis();
	}
	public static void end(){
		end=System.currentTimeMillis();
		System.out.println("此程序耗时："+(end-start)+"ms");
	}
}
