package sort;

public class InsertionSort {
	
	//��������
    public static <T extends Comparable<? super T>> void Insertionsort(T[] arr) {
        int N = arr.length;
        for(int i=1; i<N; i++)
        	for(int j=i; j>0 && arr[j].compareTo(arr[j-1]) <= 0; j--) 
        		exch(arr, j, j-1);
        double endMemory3 = (Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1000.0;
        System.out.println(endMemory3);
        return;
    }
    //��������arr�� ��i��Ԫ�����j��Ԫ�ص�λ��
  	private static <T extends Comparable<? super T>> void exch(T[] arr, int i, int j) {
  		
  		T temp = arr[i];
  		arr[i] = arr[j];
  		arr[j] = temp;
  		return;
  	}
}
