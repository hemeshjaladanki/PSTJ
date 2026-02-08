class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i,j=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                j++;
            }

        }
    }
}