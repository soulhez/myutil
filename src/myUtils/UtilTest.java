package myUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilTest {

	public static void main(String[] args) {
		// String str1 = null;
		// String str2 = "";
		// String str3 = "    ";
		// String str4 = "1";
		// String str5 = "s ";
		// System.out.println(IsNullUtil.StringIsNull(str1));
		// System.out.println(IsNullUtil.StringIsNull(str2));
		// System.out.println(IsNullUtil.StringIsNull(str3));
		// System.out.println(IsNullUtil.StringIsNull(str4));
		// System.out.println(IsNullUtil.StringIsNull(str5));

		List<String> list = null;
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		list3.add("1");
		System.out.println(IsNullUtil.collectionIsNull(list));
		System.out.println(IsNullUtil.collectionIsNull(list2));
		System.out.println(IsNullUtil.collectionIsNull(list3));
		// System.out.println(IsNullUtil.listIsNull(list));
		// System.out.println(IsNullUtil.listIsNull(list2));
		// System.out.println(IsNullUtil.listIsNull(list3));

		// String[] strings = null;
		// String[] strings2 = {};
		// String[] strings3 = { "1" };
		// System.out.println(IsNullUtil.arrIsNull(strings));
		// System.out.println(IsNullUtil.arrIsNull(strings2));
		// System.out.println(IsNullUtil.arrIsNull(strings3));

		// Map<String, String> map = null;
		// Map<String, String> map1 = new HashMap<String, String>();
		// Map<String, String> map2 = new HashMap<String, String>();
		// map2.put("", "");
		//
		// System.out.println(IsNullUtil.mapIsNull(map));
		// System.out.println(IsNullUtil.mapIsNull(map1));
		// System.out.println(IsNullUtil.mapIsNull(map2));

		// Set<String> set = new HashSet<String>();
		// Set<String> set1 = null;
		// Set<String> set2 = new HashSet<String>();
		// set2.add("");
		// // System.out.println(IsNullUtil.setIsNull(set));
		// // System.out.println(IsNullUtil.setIsNull(set1));
		// // System.out.println(IsNullUtil.setIsNull(set2));
		// System.out.println(IsNullUtil.collectionIsNull(set));
		// System.out.println(IsNullUtil.collectionIsNull(set1));
		// System.out.println(IsNullUtil.collectionIsNull(set2));

	}

}
