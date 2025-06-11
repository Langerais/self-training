package jump_game;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int target = nums.length-1;
        for(int i = nums.length-2; i >= 0; i--) target = i + nums[i] >= target ? i : target;
        return target <= 0;
    }

}
