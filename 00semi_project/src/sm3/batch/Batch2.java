package sm3.batch;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Batch2 {
	public static void main(String[] args) {
		System.out.println("배치");
		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				BatchDB2 bd2=new BatchDB2();
				int nn=bd2.batchCnt();
				if(nn>0) {
					System.out.println("재고반영배치성공");
				}else {
					System.out.println("재고반영배치실패");
				}
			}
		};
		Timer timer=new Timer(true);
		Calendar cal=Calendar.getInstance();
		cal.set(2018,8,1,19,36,0);
		timer.schedule(task, new Date(cal.getTimeInMillis()),1000*60*60*24);
		try {
			Thread.sleep(100000);//슬립으로 10분정도 대기시켰다가
		}catch(InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
		timer.cancel();
	}
}
