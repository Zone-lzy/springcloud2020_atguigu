import java.time.ZonedDateTime;

public class T2 {

	public static void main(String[] args) {
		ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
		System.out.println(zbj);
//		2021-10-03T09:54:17.870+08:00[Asia/Shanghai]
	}
}
