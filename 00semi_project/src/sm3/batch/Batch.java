package sm3.batch;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Batch {
	public static void main(String[] args) {
		System.out.println("��ġ");
		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				System.out.println("��ġ���α׷�����");
				BatchDB bd=new BatchDB();
				int n=bd.batchPur();
				if(n>0) {
					System.out.println("���Ÿ�Ϲ�ġ����");
				}else {
					System.out.println("���Ÿ�Ϲ�ġ����");
				}
			}
		};
		Timer timer=new Timer(true);
		Calendar cal=Calendar.getInstance();
		cal.set(2018,8,2,16,40,0);
		timer.schedule(task, new Date(cal.getTimeInMillis()),1000*60*60*24);
		try {
			Thread.sleep(100000);//�������� 10������ �����״ٰ�
		}catch(InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
		timer.cancel();
	}
}
