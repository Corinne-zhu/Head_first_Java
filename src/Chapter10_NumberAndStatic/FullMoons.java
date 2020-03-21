package Chapter10_NumberAndStatic;

// 算出12個月後的日期
import java.util.Calendar;

public class FullMoons {
	static int DAY_IM = 1000 * 60 * 60 * 24;

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2004, 0, 7);
		long day1 = c.getTimeInMillis();
		System.out.println(String.format("%tc", c));

		for (int i = 0; i < 12; i++) {
			day1 += (DAY_IM * 29.52);
			c.setTimeInMillis(day1);
			System.out.println(String.format("%tc", c));
		}
	}
}
