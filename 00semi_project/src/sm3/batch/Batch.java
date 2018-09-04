package sm3.batch;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Batch {
	public static void main(String[] args) {
		System.out.println("배치");
		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				System.out.println("배치프로그램가동");
				BatchDB bd=new BatchDB();
				int n=bd.batchPur();
				if(n>0) {
					System.out.println("구매목록배치 " + n +"개 성공");
				}else {
					System.out.println("구매목록배치실패");
				}
			}
		};
		Timer timer=new Timer(false);
		Calendar cal=Calendar.getInstance();
		cal.set(2018,8,4,17,27,0);
		timer.schedule(task, new Date(cal.getTimeInMillis()),1000*60*60*24);
	}
}
