package percolation;

public class Percolation {
	public Percolation(int n) {
		this.n = n;//��͸����ı䳤
	    map = new int[n*n];//��¼��͸�����и���״̬ 0��ʾclose 1��ʾopen 2��ʾfullopen
		fullopen = new int[n*n];//��¼fullopen�ĵ� ���ڲ���
	}
	private int n;
	private int[] map;
	private int[] fullopen;
	private int head = 0, tail = 0;
	public void setFullOpen(){
		int[][] trydirection = {{0,1},{1,0},{0,-1},{-1,0}};
		head = 0;
		for(int k=0;k<n;k++) { //��һ��open�Ľڵ��¼��fullopen
			if(map[k] == 1) {
				fullopen[tail] = k;
				map[k]=2;
				tail++;
			}	
		}
		while(head<tail) { //����������� ����������fullopen�������Ľڵ��¼��fullopen
			for(int k=0;k<4;k++) { //���ĸ�������г���
				int x = fullopen[head]/n;
				int y = fullopen[head]%n;
				int tx = x+trydirection[k][0];
				int ty = y+trydirection[k][1];
				//System.out.print("x="+x+"y="+y+"tx="+tx+"ty="+ty);
				if(tx<0||ty<0||tx>=n||ty>=n) { //Խ��
					//System.out.println(" Over!");
					continue;
				}
				else if(isOpen(tx,ty) == true) {
					fullopen[tail] = tx*n+ty;
					map[tx*n+ty]=2;
					tail++;
					//System.out.println(" Open it!");
				}
				//else
					//System.out.println("");
			}
			head++;
		}
		//System.out.println("head="+head+"tail="+tail);
		return;
	}
	public void open(int i,int j) {
		this.map[i*n+j] = 1;
		//System.out.println("open("+i+","+j+")");
		return;
	}
	public boolean isOpen(int i,int j) {
		if(map[i*n+j] == 1) 
			return true;
		else 
			return false;
	}
	public boolean isFull(int i,int j) {
		if(map[i*n+j] == 2) 
			return true;
		else
			return false;
	}
	public boolean percolates() {//�ж��Ƿ�ȫ��͸
		for(int p=0;p<tail;p++) {
			if(fullopen[p] > (n-1)*n)
				return true;
		}
		return false;
	}
	public void printmap() { //���ԭͼ
		for(int i=0;i<n*n;i++) {
			System.out.print(map[i]);
			if(i%n == (n-1))
				System.out.println("");
		}
	}
	public void printfullopen() { //�������͸�ĵ�
		System.out.print("fullopen:");
		for(int i=0;i<n*n;i++) {
			System.out.print(fullopen[i]+" ");
		}
		System.out.println("");
	}
}
