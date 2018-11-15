package percolation;

import java.util.Scanner;

public class percolationstats {

	private static double[] p; //��¼ÿ�ε���͸��
	private static int n = 0,t = 0;
	private static double mean = 0,dev = 0,low = 0,high = 0;
	public percolationstats(int n,int t) {
	
		p = new double[t];
		for(int i=0;i<t;i++) {
			Percolation per = new Percolation(n);
			while(per.percolates() == false) { //��n*n��������δ��͸ʱ �򿪶�ס�ĵ�
				int x = (int)(Math.random()*n);
				int y = (int)(Math.random()*n);
				if(per.isOpen(x,y)==false && per.isFull(x,y)==false ) {
					per.open(x,y);
					p[i]++;
				}
				per.setFullOpen(); //���¼���ȫ͸���ĵ�
			}
			p[i] = p[i]/(n*n);
			//System.out.println("p["+i+"]="+p[i]);
		}
		/*double temp = 0; //��͸�ʰ����� ð������
		for(int i=0;i<t;i++) {
			for(int j=i;j<t;j++) {
				if(p[i]>p[j]) {
					temp = p[i];
					p[i] = p[j];
					p[j] = temp;
				}
			}
		}*/
		
	}
	public double mean() {//��ƽ����
		double sum = 0;
		for(int i=0;i<t;i++) {
			sum = sum+p[i];
		}
		mean = sum/t;
		return mean;
	}
	public double stddev() {//��ƫ��
		double sum = 0;
		for(int i=0;i<t;i++) {
			sum = sum+(p[i]-mean)*(p[i]-mean);
		}
		return Math.sqrt(sum/t);
	}
	public double confidenceLo() {//������������½�
		
		return mean-dev/Math.sqrt(t)*1.96;
	}
	public double confidenceHi() {//������������Ͻ�
		
		return mean+dev/Math.sqrt(t)*1.96;
	}
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("����߳� n =");
		n = in.nextInt();
		System.out.println("ʵ����� t =");
		t = in.nextInt();
		in.close();
		long startTime = System.nanoTime();//��¼��ʼ��ʱ��
		percolationstats per = new percolationstats(n,t);
		long endTime = System.nanoTime();//��¼������ʱ��
		long time = (endTime-startTime)/1000;
		System.out.print("Time = ");
        System.out.print(time);
        System.out.println("ms");
        
		mean = per.mean(); //��͸�ʵ�ƽ��ֵ
		dev = per.stddev();//��͸�ʵķ���
		low = per.confidenceLo();//�������5%ʱ����Сֵ
		high = per.confidenceHi();//�������5%ʱ�����ֵ
		
		System.out.println("mean="+mean);
		System.out.println("dev="+dev);
		System.out.println("low="+low);
		System.out.println("high="+high);
		  
	    System.out.println(Runtime.getRuntime().totalMemory());//���java������ִ�д˳���ʱ�ڲ���ϵͳ����ռ�ڴ�
		
		return;
	}
}
