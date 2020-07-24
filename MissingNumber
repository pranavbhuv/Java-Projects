import java.util.*;

class MissingNumber
{
	public static void main(String []args)
	{
		int[] arr = {1, 2, 3, 5, 6, 8, 9, 10, 12, 13, 15};
		if(finder(arr).size() != 0)
		{
			System.out.println("Missing Number: " + cleanser(finder(arr)) + "\n");
		}
		else
		{
			System.out.println("There is no missing numbers!");
		}
	}
	
	public static ArrayList<Integer> finder(int[] arr)
	{
		ArrayList<Integer> values = new ArrayList<Integer>();
		for(int i = 0; i < arr.length; i++)
		{
			if(i + 1 == arr.length)
			{
				return values;
			}
			for(int j = i; j < arr.length; j++)
			{
				if((arr[i+1] - arr[i]) != 1)
				{
					int real = arr[i] + 1;
					values.add(real);
				}
			}
		}
		return values;
	}

	public static ArrayList<Integer> cleanser(ArrayList<Integer> values)
	{
		ArrayList<Integer> newlist = new ArrayList<Integer>();
		for(int i = 0; i < values.size(); i++)
		{
			if(!newlist.contains(values.get(i)))
			{
				newlist.add(values.get(i));
			}
		}
		return newlist;
	}
}
