package myutils.dateutil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间操作工具类
 * 
 * @author 涂宗勋
 * @date 2018年2月24日
 */
public class DateUtil {

	private static final String yyyyMMdd = "yyyyMMdd";
	private static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	private static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";

	/**
	 * 把date转换成自定义格式的字符串
	 * 
	 * @auth 涂宗勋
	 * @param date
	 * @param str
	 * @return
	 */
	public static String getDateStr(Date date, String str) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(str);
		return dateFormat.format(date);
	}

	/**
	 * 根据date获取yyyyMMdd的格式化字符串
	 * 
	 * @auth 涂宗勋
	 * @param date
	 * @return
	 */
	public static String getyyyyMMdd(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(yyyyMMdd);
		return dateFormat.format(date);
	}

	/**
	 * 根据date获取yyyyMMddHHmmss的格式化字符串
	 * 
	 * @auth 涂宗勋
	 * @param date
	 * @return
	 */
	public static String getyyyyMMddHHmmss(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(yyyyMMddHHmmss);
		return dateFormat.format(date);
	}

	/**
	 * 根据date获取yyyyMMddHHmmssSSS的格式化字符串
	 * 
	 * @auth 涂宗勋
	 * @param date
	 * @return
	 */
	public static String getyyyyMMddHHmmssSSS(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(yyyyMMddHHmmssSSS);
		return dateFormat.format(date);
	}

	/**
	 * 把Date转换成Calendar
	 * 
	 * @auth 涂宗勋
	 * @return
	 */
	public static Calendar dateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * 对当前date类型的时间做天的加减操作
	 * 
	 * @auth 涂宗勋
	 * @param date
	 * @return
	 */
	public static Date addDayToDate(Date date, int day) {
		Calendar calendar = dateToCalendar(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();

	}

	/**
	 * 对当前date类型的时间做月的加减操作
	 * 
	 * @auth 涂宗勋
	 * @param date
	 * @return
	 */
	public static Date addMonthToDate(Date date, int month) {
		Calendar calendar = dateToCalendar(date);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}

	/**
	 * 对当前date类型的时间做年的加减操作
	 * 
	 * @auth 涂宗勋
	 * @param date
	 * @return
	 */
	public static Date addYearToDate(Date date, int year) {
		Calendar calendar = dateToCalendar(date);
		calendar.add(Calendar.YEAR, year);
		return calendar.getTime();
	}

	/**
	 * 对当前date类型的时间做周的加减操作
	 * 
	 * @auth 涂宗勋
	 * @param date
	 * @return
	 */
	public static Date addWeekToDate(Date date, int week) {
		Calendar calendar = dateToCalendar(date);
		calendar.add(Calendar.WEEK_OF_MONTH, week);
		return calendar.getTime();
	}

	/**
	 * 测试方法
	 * 
	 * @auth 涂宗勋
	 * @param args
	 */
	public static void main(String[] args) {
		// System.out.println(DateUtil.getyyyyMMdd(new Date()));
		// System.out.println(DateUtil.getyyyyMMddHHmmss(new Date()));
		System.out.println(DateUtil.getyyyyMMddHHmmssSSS(new Date()));
		// Calendar calendar = Calendar.getInstance();
		// calendar.set(2018, 2, 9);
		// Date date = calendar.getTime();
		// System.out.println(DateUtil.dateToCalendar(date).get(3));
		// System.out.println(getyyyyMMddHHmmss(addDayToDate(new Date(), -30)));
		// System.out.println(getyyyyMMddHHmmss(addMonthToDate(new Date(),
		// -1)));
		// System.out.println(getyyyyMMddHHmmss(addYearToDate(new Date(), -1)));
		// System.out.println(getyyyyMMddHHmmss(addWeekToDate(new Date(), -1)));
	}

}
