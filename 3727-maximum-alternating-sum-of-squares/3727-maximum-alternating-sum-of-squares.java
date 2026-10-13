class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) nums[i]=nums[i]*-1;
        }
       Arrays.sort(nums);
        long ans=0;
        int i=0;
        int j=nums.length-1;
        while(i<j){
            ans+=((long)nums[j]*nums[j]-(long)nums[i]*nums[i]);
            i++;
            j--;
        }
        if(nums.length%2==1) ans+=(long)nums[j]*nums[j];
        return ans;
    }
}