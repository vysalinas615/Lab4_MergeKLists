import java.util.*;

public class KLists
//make array of indicies
//what does that mean?? ^^
{
	public static void printOriginalArray(double[][] someList)
	{
		System.out.println();
		System.out.print("Input: ");
		System.out.print("{");
		for (int x=0;x<someList.length;x++)
		{
			for (int y=0;y<someList[x].length;y++)
			{
				if (y<someList.length-1)
				{
					System.out.print(someList[x][y]+", ");
				}

				else if(y==someList.length-1&&someList.length>1)
				{
					System.out.print(someList[x][y]+"} {");
				}

				else if (someList.length<=1)
				{
					System.out.print(" "+someList[x][y]+" ");
				}
			}
		}
		System.out.println("}");
	}


	public static List<Double> removeExtraValue(double[] someList, int nItems)
	{
		//double[] aList = new double[someList.length];
		List<Double> aList = new ArrayList<Double>();
		for (int i=0;i<someList.length;i++)
		{
			if (someList[i]!=0.0&&nItems<someList.length)
			{
				//aList[i]=someList[i];
				aList.add(someList[i]);
			}

			else
			{
				aList.add(someList[i]);
				aList.remove(someList[i]);
			}
		}
		System.out.println();
		System.out.print("{");
		for (int u=0;u<aList.size();u++)
		{
			//System.out.println("Index: "+u+" size: "+aList.size());
			if (u<aList.size()-1)
			{
				System.out.print(aList.get(u)+", ");
			}

			else if(u==aList.size()-1)
			{
				System.out.print(aList.get(u)+"}");
			}
		}
		System.out.println();
	  return aList;
	}

	public static void printList(double[] someList)
	{
		System.out.print("{");
		for (int i=0;i<someList.length;i++)
		{
			if (i==someList.length-1)
			{
				System.out.print(someList[i]);
			}

			else
			{
				System.out.print(" "+someList[i]+", ");
			}
		}
		System.out.print("}");
		System.out.println();
	}

	//singleItem checks if the outer array only has 1 inner array, if so it merges the item(s) into an array called oneItem
	//public static double[] singleItem(double[][] outerArray, int numOfArrays, int totalNumOfItems)
	public static int singleItem(double[][] outerArray, int numOfArrays, int totalNumOfItems)
	{
		double[] oneItem = new double[totalNumOfItems];
		int resultNum;

		if (outerArray.length==1)
		{
			int k=0;

			while (k<oneItem.length)
			{
				for (int i=0;i<outerArray.length;i++)
				{
					for (int h=0;h<outerArray[i].length;h++)
					{
						oneItem[k]=outerArray[i][h];
						k++;
					}
				}
			}

			System.out.print("Output: ");
			System.out.print("{");

			for (int j=0;j<oneItem.length;j++)
			{
				if (j==oneItem.length-1)
				{
					System.out.print(oneItem[j]);
				}

				else
				{
					System.out.print(" "+oneItem[j]+", "); 
				}
			}
		  System.out.print("}\n");
		  resultNum=1; 
		}

		else
		{
			System.out.println();
			System.out.println("Outer array has more than 1 inner array.");
			resultNum=0;
		}

	  //return oneItem;
	  return resultNum;
	}

	public static double[] mergeKLists(double [][] outerArray)
	{
		//Find midpoint, split arrays, compare items, then add to array
		int sizeA;
		int sizeB;

		int originalSize =0;

		for (int x=0;x<outerArray.length;x++)
		{
			for (int y=0;y<outerArray.length;y++)
			{
				//outerArray[x][y]=originalSize;
				originalSize++;
			}
		}

		double[] mergedList = new double[originalSize];

		int e=0;

		for (int b=0; b<outerArray.length; b++)
		{
			for (int c=0; c<=outerArray[b].length-1; c++)
			{
				mergedList[e]=outerArray[b][c];
				e++;
			}
		}
		//adds items to 1 collective unsorted list

		double[] sortedListA = new double[mergedList.length/2];
		double[] sortedlistB;

		if (outerArray.length%2!=0)
		{
			sortedlistB = new double[mergedList.length/2 +1];
		}

		else
		{
			sortedlistB = new double[mergedList.length/2];
		}

		//creates left array & prints
		for (int l=0;l<mergedList.length/2;l++)
		{
			sortedListA[l]=mergedList[l];
		}

		//creates right array & prints
		for (int r=0;r<sortedlistB.length;r++)
		{
			sortedlistB[r]=mergedList[(mergedList.length/2) +r];
		}

		double[] sortedAndMerged = new double[sortedListA.length+sortedlistB.length];
		//can't recursively call since it only takes in a 2d array
		sortedListA = sortItems(sortedListA);
		sortedlistB = sortItems(sortedlistB);
		sortedAndMerged = mergeItems(sortedListA,sortedlistB);

	  return sortedAndMerged;
	}

	public static double[] sortItems(double[] aList)
	{
		//used insertion sort to sort since mergesort was not working recursively
		System.out.println("Sorting...");

		for(int i=1;i<aList.length;i++)
		{
			double temp = aList[i];
			int j=i-1;
			while(j>=0&&aList[j]>temp)
			{
				aList[j+1]=aList[j];
				--j;
			}
		  aList[j+1]=temp;
		}
	  return aList;
	}

	public static double[] mergeItems(double[] left, double[] right)
	{
		int pointer1=0;
		int pointer2=0;
		int targetPointer=0;
		double[] target = new double[left.length+right.length];

		while (pointer1<left.length && pointer2<right.length)
		{
			if (left[pointer1]>right[pointer2])
			{
				target[targetPointer]=right[pointer2];
				targetPointer++;
				pointer2++;
			}

			else
			{
				target[targetPointer]=left[pointer1];
				targetPointer++;
				pointer1++;
			}
		}

		while (pointer1<left.length)
		{
			target[targetPointer]=left[pointer1];
			targetPointer++;
			pointer1++;
		}

		while (pointer2<right.length)
		{
			target[targetPointer]=right[pointer2];
			targetPointer++;
			pointer2++;
		}
	  //printList(target);
	  return target;
	}

	public static void main(String[] args)
	{
		Scanner scan1 = new Scanner(System.in);
		int kLists;
		System.out.println("Enter number of arrays inside of the outer array.");
		kLists = scan1.nextInt();
		System.out.println();
		int nItems;
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Enter total number of individual values in the outer array.");
		nItems = scan2.nextInt();

		//**************************************************************************************
		//PLUG IN YOUR OWN VALUES HERE:

		double[][] outerArray = { {1.1, 4.4, 5.5}, {1.1,3.3,4.4}, {2.2, 6.6} }; 
		//double[][] outerArray = {{}};
		//double[][] outerArray = { {1.1} };
		//double[][] outerArray = { {1.1, 2.2, 3.3, 7.7} };
		//double[][] outerArray = {{2.2,3.3}, {1.1, 5.5}};

		//**************************************************************************************


		//double[] result1 = new double[outerArray.length];
		//result1=singleItem(outerArray,kLists,nItems);

		System.out.println();
		printOriginalArray(outerArray);
		int result1;
		result1=singleItem(outerArray,kLists,nItems);

		double[] result2;
		//double[] result3;
		List<Double> result3 = new ArrayList<Double>();

		if (result1!=1)
		{
			System.out.println();
			//add a variable to catch the array made by mergeKlists
			result2 = mergeKLists(outerArray);
			//add if statement here to see if nItems is greater than the length of the result array
			if (nItems<result2.length)
			{
				result3 = removeExtraValue(result2, nItems);
				//if so call remove items
			}

		}
	}
}