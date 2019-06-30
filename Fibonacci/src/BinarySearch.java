
public class BinarySearch {

	public static void main(String[] args) {
		int a[] = {5,5,7,3,8,5,3,4,6,7,4,3,2,5,6,7,4,3,2,3,34,5,6,7,4,3,2,4};
		int x = 2;
		System.out.println(binarySearch(a,x));

	}
	
	private static boolean binarySearch(int a[],int x) {
		return rec_binarySearch(a,x,a[0],a[a.length-1]);
	}
	
	private static boolean rec_binarySearch(int a[],int x,int start,int end) {
		if(end<start)
			return false;
		int mid=(end-start)/2;
		if()
			return rec_binarySearch(a,x,start,mid);
		else if()
			return rec_binarySearch(a,x,mid+1,end);
		else
			return mid;
	}

}
