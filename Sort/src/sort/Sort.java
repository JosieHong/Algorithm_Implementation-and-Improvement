package sort;

public class Sort {

	private static final int MAX = 10000;//���������С�ĺ�
	private static final int SIZE = 10;//����Ԫ�ش�С�ĺ�
	public static void main(String[] args) {
		
		Integer[] arr = new Integer[MAX];
		for(int i=0;i<MAX; i++) {
			arr[i] = (int)(Math.random()*SIZE);
		}
		System.out.println("MAX = "+MAX+" SIZE = "+SIZE);
		
		//��������
        long startTime3 = System.nanoTime();//��¼��ʼ��ʱ��
        InsertionSort.Insertionsort(arr);
        long endTime3 = System.nanoTime();//��¼������ʱ��
        long time3 = (endTime3-startTime3)/1000;
        System.out.print("InsertionSort:     		    Time = ");
        System.out.println(time3+"ms");
        /*for (Integer i : arr)
            System.out.print(i + " ");
        System.out.println("");*/
		
		//�Զ����µĹ鲢����
		long startTime1 = System.nanoTime();//��¼��ʼ��ʱ��
        MergeSortBH.TopdownMergesort(arr);
        long endTime1 = System.nanoTime();//��¼������ʱ��
        long time1 = (endTime1-startTime1)/1000;
        System.out.print("TopdownMergeSort:   		    Time = ");
        System.out.println(time1+"ms");
        /*for (Integer i : arr1)
            System.out.print(i + " ");
        System.out.println("");*/
        
        //�Ե����ϵĹ鲢����
        long startTime2 = System.nanoTime();//��¼��ʼ��ʱ��
        MergeSortBU.BottomupMergesort(arr);
        long endTime2 = System.nanoTime();//��¼������ʱ��
        long time2 = (endTime2-startTime2)/1000;
        System.out.print("BottomupMergeSort:   		    Time = ");
        System.out.println(time2+"ms");
        /*for (Integer i : arr2)
            System.out.print(i + " ");
        System.out.println("");*/
        
        //�����������
        long startTime4 = System.nanoTime();//��¼��ʼ��ʱ��
        RandomQuickSort.RandomQuicksort(arr);
        long endTime4 = System.nanoTime();//��¼������ʱ��
        long time4 = (endTime4-startTime4)/1000;
        System.out.print("RandomQuickSort: 		    Time = ");
        System.out.println(time4+"ms");
        /*for (Integer i : arr4)
            System.out.print(i + " ");
        System.out.println("");*/

        
        //Dijkstra 3-·���ֿ�������
        long startTime5 = System.nanoTime();//��¼��ʼ��ʱ��
        QuickSortwithDijkstra3wayPartition.QuicksortwithDijkstra3wayPartition(arr);
        long endTime5 = System.nanoTime();//��¼������ʱ��
        long time5 = (endTime5-startTime5)/1000;
        System.out.print("QuickSortwithDijkstra3wayPartition: Time = ");
        System.out.println(time5+"ms");
        /*for (Integer i : arr5)
            System.out.print(i + " ");
        System.out.println("");*/   
    }

}
