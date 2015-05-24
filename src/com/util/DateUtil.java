/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author rick.y
 */
public class DateUtil {
	private static final java.text.SimpleDateFormat smt01 = new java.text.SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static final java.text.SimpleDateFormat smt02 = new java.text.SimpleDateFormat(
			"dd日HH:mm");
	private static final java.text.SimpleDateFormat smt03 = new java.text.SimpleDateFormat(
			"HH:mm:ss");
	private static final java.text.SimpleDateFormat smt04 = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");
	private static final java.text.SimpleDateFormat smtwk = new java.text.SimpleDateFormat(
			"EEEE");

	public static int BASECOST15MIN;
	public static int VIPZK;
	public static int AUTOFLASH;

	public static String date2Str(int smt, Date insdate) {

		if (insdate == null) {
			return null;
		} else {
			if (smt == 1) {
				return smt01.format(insdate);
			} else if (smt == 2) {
				return smt02.format(insdate);
			} else if (smt == 3) {
				return smt03.format(insdate);
			} else if (smt == 4) {
				return smt04.format(insdate);
			} else if (smt == 5) {
				return smtwk.format(insdate);
			} else {
				return null;
			}
		}

	}

	public static int formatDayInt(String insStr) {
		if (insStr == null)
			insStr = "902";
		return Integer.parseInt(insStr.substring(0, 2));
		
	}

	public static Date str2Date01(String insStr) {
		try {
			return smt01.parse(insStr);
		} catch (ParseException ex) {
			Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null,
					ex);
			return null;
		}
	}

	public static Date str2Date02(String insStr) {
		try {
			return smt02.parse(insStr);
		} catch (ParseException ex) {
			Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null,
					ex);
			return null;
		}
	}
	
	public static Date str2Date04(String insStr) {
		try {
			return smt04.parse(insStr);
		} catch (ParseException ex) {
			Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null,
					ex);
			return null;
		}
	}

}
