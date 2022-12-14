// problem 5
import java.util.*;

class Permutation
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int[] nums = {1, 2, 3, 4};
		List<List<Integer>> res = new ArrayList<>();
		backtrack(nums, 0, res);
		
		for(List<Integer> l : res)
			System.out.println(l);
		s.close();
	}
	
	public static void backtrack(int[] nums,int level,List<List<Integer>>res){
    	if(level == nums.length)
		{
    		List<Integer> addable=new ArrayList<Integer>();
    		
			for(int i=0;i<nums.length;i++)
    			addable.add(nums[i]);
			
    		res.add(addable);
    	}
		
    	for(int i=level;i<nums.length;i++){
    		swap(nums,i,level);
    		backtrack(nums,level+1,res);
    		swap(nums,i,level);
    	}
    }
    
    public static void swap(int[]nums,int i,int j){
    	int temp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }
}