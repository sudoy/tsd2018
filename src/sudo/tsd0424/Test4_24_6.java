package sudo.tsd0424;

import java.time.LocalDate;

public class Test4_24_6 {

	public static void main(String[] args) {
		String[][] holidays = {
				{ "2018-01-01", "元日" },
				{ "2018-01-08", "成人の日" },
				{ "2018-02-11", "建国記念の日" },
				{ "2018-02-12", "振替休日" },
				{ "2018-03-21", "春分の日" },
				{ "2018-04-29", "昭和の日" },
				{ "2018-04-30", "振替休日" },
				{ "2018-05-03", "憲法記念日" },
				{ "2018-05-04", "みどりの日" },
				{ "2018-05-05", "こどもの日" },
				{ "2018-07-16", "海の日" },
				{ "2018-08-11", "山の日" },
				{ "2018-09-17", "敬老の日" },
				{ "2018-09-23", "秋分の日" },
				{ "2018-09-24", "振替休日" },
				{ "2018-10-08", "体育の日" },
				{ "2018-11-03", "文化の日" },
				{ "2018-11-23", "勤労感謝の日" },
				{ "2018-12-23", "天皇誕生日" },
				{ "2018-12-24", "振替休日" }
		};

		int year = 2018;
		int month = 5;

		LocalDate date = LocalDate.of(year, month, 1);
		while(date.getMonthValue() == month) {

			System.out.print(date);

			for(String[] holiday : holidays) {
				// dateとholidayが同日だったら
				String str = holiday[0];
				LocalDate target = LocalDate.parse(str);

				if(date.equals(target)) {
					System.out.print(holiday[1]);
				}
			}
			System.out.println();
			date = date.plusDays(1);
		}

	}

}
