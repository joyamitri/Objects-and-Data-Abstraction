public class binary_search {
    public static int binarySearch(int[] arr, int k, int first, int last) {

		if ((last == first) && arr[first] != k) // if last is first this means all the arraay was scanned and not found
			return -1;
		else {
			int middle = (first + last) / 2;// The start index is in the middle of the array

			if (arr[middle] == k)// if middle is equal to k then we will return the index were we found it
				return middle;

			else {
				if (arr[middle] > k) // if k is less than the element at index middle then everything for an index
										// bigger than middle will be more than k
					last = middle - 1;// This is why we set last to middle -1

				else
					first = middle + 1;// Similarly if the element is less than k than everything below middle will be
										// less, thus we set first to middle +1

				return binarySearch(arr, k, first, last);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 3, 5, 7, 8, 9, 12 };
		int i = binarySearch(arr, 9, 0, arr.length - 1);
		if (i == -1)
			System.out.println("Not found");
		else
			System.out.println("Found at: " + i);

	}
}