class Solution {
//1: use dfs
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     List<Integer> subset = new ArrayList<>();
    //     dfs(nums, 0, subset, res);
    //     return res;
    // }

    // private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
    //     if (i >= nums.length) {
    //         res.add(new ArrayList<>(subset));
    //         return;
    //     }
    //     subset.add(nums[i]);
    //     dfs(nums, i + 1, subset, res);
    //     subset.remove(subset.size() - 1);
    //     dfs(nums, i + 1, subset, res);
    // }

//2: use bitmask
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     int n = nums.length;
    //     int total = 1 << n;

    //     for (int mask = 0; mask < total; mask++) {
    //         List<Integer> subset = new ArrayList<>();

    //         for (int i = 0; i < n; i++) {
    //             if ((mask & (1 << i)) != 0) {
    //                 subset.add(nums[i]);
    //             }
    //         }

    //         res.add(subset);
    //     }

    //     return res;
    // }

//3: use backtracking
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
