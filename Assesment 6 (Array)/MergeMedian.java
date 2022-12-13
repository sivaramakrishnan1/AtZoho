import java.util.Scanner;

class MergeMedian
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int pos = 0;
		int[] nums1 = new int[s.nextInt()];
		int[] nums2 = new int[s.nextInt()];
		int[] res = new int[nums1.length + nums2.length];
		
		for(int i = 0 ; i < nums1.length ; i++) nums1[i] = s.nextInt();
		
		for(int i = 0 ; i < nums2.length ; i++) nums2[i] = s.nextInt();
		
		int i=0, j=0;
		while(i < nums1.length || j < nums2.length)
		{
			if(pos > res.length / 2)
				break;
			if(i >= nums1.length)
			{
				res[pos++] = nums2[j++];
			}
			else if(j >= nums2.length)
			{
				res[pos++] = nums1[i++];
			}			
			else if(i < nums1.length && j < nums2.length && nums1[i] < nums2[j])
			{
				res[pos++] = nums1[i++];
			}
			else 
			{
				res[pos++] = nums2[j++];
			}
		}
		
		double med = 0;
		
		if(res.length % 2 == 0) {
			med = (double)(res[(res.length/2) - 1] + res[(res.length/2)]) / (double)2;
		} else {
			med = res[res.length/2];
		}
		
		System.out.println("Median: " + med);
		
		s.close();
	}
}