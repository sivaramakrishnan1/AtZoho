import java.util.Scanner;
class Robber
{
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		Robber r = new Robber();
		int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++)
			arr[i] = s.nextInt();
		
		 
		// int[] arr = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
		s.close();
		
		System.out.println(r.rob(arr));
	}
	
	
	public int rob(int[] nums)
	{
		return robMore(nums, 0, 0);
	}
	
	public int robMore(int[] nums, int val, int pos)
	{
		if(pos >= nums.length)
			return val;
		
		int m = 0, curr = 0;
		for(int i = pos ; i < nums.length ; i++)
		{
			curr = robMore(nums, val + nums[i], i+2);
			if(m < curr)
				m = curr;
		}
		
		return m;
	}
	
	
	/* int[] map;
	public int rob(int[] nums)
	{
		map = new int[nums.length];
		robMore(nums, 0, nums.length - 1, "");
		int max = 0;
		for(int i = 0 ; i < map.length ; i++)
		{
			max = (max < map[i]) ? map[i] : max;
			// System.out.print(map[i] + " ");
		}
		// System.out.println(max);
		return max;
	}
	
	public int robMore(int[] nums, int val, int pos, String path)
	{
		if(pos < 0) {
			System.out.println(path);
			return val;
		}
		
		if(map[pos] != 0)
			return map[pos];
		
		int m = 0, curr = 0;
		for(int i = pos ; i > -1 ; i--)
		{
			curr = robMore(nums, val + nums[i], i+2, path + " " + nums[i]);
			if(m < curr)
				m = curr;
		}
		map[pos] = m;
		return m;
	} */
	// 
	
	/* public int rob(int[] arr) {
        int max = 0;
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			int pos = maxpos(arr);
			
			if(pos == -1)
			{
                return max;
			}
			max += arr[pos];

			arr[pos] = Integer.MIN_VALUE;
			if(pos != 0) arr[pos-1] = Integer.MIN_VALUE;
			if(pos != arr.length -1) arr[pos+1] = Integer.MIN_VALUE;			
		}

        return max;
    }
	
	public int maxpos(int[] arr)
	{
		int max = Integer.MIN_VALUE, maxpos = -1;
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(arr[i] > max)
			{
				max = arr[i];
                maxpos = i;
				// System.out.println(max + " " + maxpos);
			}
		}
		
		return maxpos;
	} */
} 