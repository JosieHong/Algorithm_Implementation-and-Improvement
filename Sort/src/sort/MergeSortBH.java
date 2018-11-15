package sort;

public class MergeSortBH{
	
	//�Զ����µĹ鲢����
    public static <T extends Comparable<? super T>> void TopdownMergesort(T[] arr) {
        T[] tmpArray = (T[]) new Comparable[arr.length]; //�鲢���踨������tmpArray
        //ע�� ��Ҫ������ת����������T[] tmpArray = new Comparable<T>[arr.length];
        TopdownMergesort(arr, tmpArray, 0, arr.length - 1);
    }
    private static <T extends Comparable<? super T>> void TopdownMergesort(T[] arr,T[] tmpArray, int lo, int hi) {
        if (lo < hi){
            int mid = (lo + hi) / 2;
            TopdownMergesort(arr, tmpArray, lo, mid);	 //����������
            TopdownMergesort(arr, tmpArray, mid + 1, hi);//���Ұ������
            merge(arr, tmpArray, lo, mid, hi);			 //�鲢���
            return;
        }
        else
        	return;
    }
    //ԭ�ع鲢
    private static <T extends Comparable<? super T>> void merge(T[] arr,T[] tmpArray, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
		for(int k=lo; k<=hi; k++)
			tmpArray[k] = arr[k];
		for(int k=lo; k<=hi; k++) {
			if(i>mid)
				arr[k] = tmpArray[j++];
			else if(j>hi)
				arr[k] = tmpArray[i++];
			else if(arr[j].compareTo(arr[i]) <= 0) //arr[j]<arr[i]
				arr[k] = tmpArray[j++];
			else
				arr[k] = tmpArray[i++];
		}
		return;
    }
    public static double memory() {
		return (Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1000.0;
    }
}