package programmer.zaman.now.i18n;

import java.util.HashMap;

public class Tess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 5, 7, 1 };
		int target = 9;

		HashMap<Integer, Integer> memo = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			var res = target - nums[i];
			if (memo.containsKey(res)) {
				System.out.println(nums[i]);
				System.out.println(memo.get(res));
			} else {
				memo.put(nums[i], i);
			}
		}
	}

}
