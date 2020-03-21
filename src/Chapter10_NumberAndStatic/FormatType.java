package Chapter10_NumberAndStatic;

import java.util.Date;

// 格式化結構
public class FormatType {

	public static void main(String[] args) {
//		String s = String.format("%, d", 1200003665);
//		System.out.println(s);
//
//		s = String.format("%,.2f", 1200.36621);
//		System.out.println(s);
//
//		s = String.format("%f", 1200.36621);
//		System.out.println(s);
//
//		s=String.format("%,6.1f", 42.000);
//		System.out.println(s);


		// 時間與日期
		System.out.println(String.format("%tc", new Date())); // 完整的日期與時間

		System.out.println(String.format("%tr", new Date()));

		//週， 月， 日
		Date today  = new Date();
		System.out.println(String.format("%tA ,%tB ,%td", today, today,today));
		System.out.println(String.format("%tA ,%<tB ,%<td", today));  // < 符號表示重複利用之前的參數


	}

}
