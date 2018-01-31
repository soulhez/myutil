package myUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 常用对象的非空判断工具类:需要进行非空判断的常用对象，一般有List、String、Map、数组等
 * 
 * @author tzx
 *
 */
public class IsNullUtil {

	/**
	 * 
	 * String的非空判断
	 * 
	 * @param str
	 * @return true:是空的，null或者"",或者多个空格的空字符串； false：非空
	 */
	public static boolean strIsNull(String str) {
		if (str == null || "".equals(str) || str.trim().equals("")) {
			return true;
		}
		return false;
	}

	/**
	 * List的非空判断
	 * 
	 * @param list
	 * 
	 * @return true:是空的，null或者空list； false：非空
	 */
	public static boolean listIsNull(List<?> list) {
		if (list == null || list.size() <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * array的非空判断
	 * 
	 * @param oar
	 * @return true:是空的，null或者空数组； false：非空
	 */
	public static boolean arrIsNull(Object[] oar) {
		if (oar == null || oar.length <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * map的非空判断
	 * 
	 * @param map
	 * @return true:是空的，null或者空map； false：非空
	 */
	public static boolean mapIsNull(Map<?, ?> map) {
		if (map == null || map.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * set的非空判断
	 * 
	 * @param set
	 * @return true:是空的，null或者空set； false：非空
	 */
	public static boolean setIsNull(Set<?> set) {
		if (set == null || set.size() <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 集合的非空判断
	 * 
	 * @param collection
	 * @return true:是空的，null或者空集合； false：非空
	 */
	public static boolean collectionIsNull(Collection<?> collection) {
		if (collection == null || collection.size() <= 0) {
			return true;
		}
		return false;
	}

}
