public class MaximumWealth {

	public static void main(String[] args) {
		int[][] accounts = { { 1, 2 }, { 2, 3 } };
		System.out.println(maximumWealth(accounts));
	}

	public static int maximumWealth(int[][] accounts) {

		int max = Integer.MIN_VALUE;
		for (int[] account : accounts) {

			int partial = 0;
			for (int weal : account) {
				partial += weal;
			}

			max = Math.max(max, partial);
		}

		return max;
	}
}
