package AStar;

import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Test {

    public static void main(String[] args) {
    	
        In in = new In("mapall.txt");
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        
        System.out.println("������Դ�㣨����-1�������ң���");
        Scanner sin = new Scanner(System.in);
        int s = sin.nextInt();
        if(s<0)
        	return;
        System.out.println("�������յ㣨����-1�������ң���");
        int aim = sin.nextInt();
        if(aim<0)
        	return;
        
        while(s>=0 && aim>=0) {
        	// compute shortest paths
        	long startTime = System.currentTimeMillis();//��¼��ʼ��ʱ��
        	AStar as = new AStar(G, s, aim);
            long endTime = System.currentTimeMillis();//��¼������ʱ��
        	
        	//��ӡԴ��Ŀ��ڵ�����·��
        	if (as.hasPathTo(aim)) {
                StdOut.printf("%d to %d (%.2f)  ", s, aim, as.distTo(aim));
                for (DirectedEdge e : as.pathTo(aim)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, aim);
            }
        	System.out.print("time = ");
        	System.out.print(endTime-startTime);
        	System.out.println("ms");
            
            System.out.println("������Դ�㣨����-1�������ң���");
            s = sin.nextInt();
            if(s == -1)
            	return;
            System.out.println("�������յ㣨����-1�������ң���");
            aim = sin.nextInt();
            if(aim == -1)
            	return;
        }
        sin.close();
    }
}
