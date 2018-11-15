package sort;

public class RandomQuickSort {
	
	//�����������
	public static <T extends Comparable<? super T>> void RandomQuicksort(T[] arr) {
		
		RandomQuicksort(arr, 0, arr.length-1);
	}
	private static <T extends Comparable<? super T>> void RandomQuicksort(T[] arr, int lo, int hi) {
		
		if(hi<=lo)
			return;
		int j = partition(arr, lo, hi);//�з�
		RandomQuicksort(arr, lo, j-1);//����벿������
		RandomQuicksort(arr, j+1, hi);//���Ұ벿������
		return;
	}
	//�������з�Ϊarr[lo...i-1] arr[i] arr[i+1...hi]
	private static <T extends Comparable<? super T>> int partition(T[] arr, int lo, int hi) {
		
		int x = ((int)Math.random() % arr.length) + lo;//����һ��0...arr.length-1��һ���������Ϊ��Ԫ�����
		exch(arr, x, lo);//������Ԫ���һ��Ԫ�أ��������������ͬ
		int i = lo, j = hi+1;
		T v = arr[lo];//�з�Ԫ��
		while(true) {
			//ɨ�����ң����ɨ���Ƿ����������Ԫ��
			while(arr[++i].compareTo(v)<=0)
				if(i==hi)
					break;
			while(v.compareTo(arr[--j])<=0)
				if(j==lo)
					break;
			if(i>=j)
				break;
			exch(arr, i, j);
		}
		exch(arr, lo, j);
		return j;
	}
	//��������arr�� ��i��Ԫ�����j��Ԫ�ص�λ��
	private static <T extends Comparable<? super T>> void exch(T[] arr, int i, int j) {
		
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return;
	}
}
