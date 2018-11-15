package sort;

public class MergeSortBU {
	
    //�Ե����ϵĹ鲢����
    public static <T extends Comparable<? super T>> void BottomupMergesort(T[] arr) {
    	T[] tmpArray = (T[]) new Comparable[arr.length]; //�鲢���踨������tmpArray
    	//ע�� ��Ҫ������ת����������T[] tmpArray = new Comparable<T>[arr.length];
    	int N = arr.length;
    	for(int sz=1; sz<N; sz=sz+sz)
    		for(int lo=0; lo<N-sz; lo+=sz+sz)
    		   merge(arr, tmpArray, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
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
}
