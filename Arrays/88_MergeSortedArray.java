//Time Complexity --> Linear time  O(m+n)
//Space Complexity --> Linear extra space  O(m+n)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums[]= new int[n+m];
        int k=0;
        int i=0,j=0;
        while(i<m && j<n){
            if(nums1[i] <= nums2[j]){
                nums[k]=nums1[i];
                i++;
                k++;
            }
            else{
                nums[k]=nums2[j];
                j++;
                k++;
            }
        }
        // merge remaining elements
        while(i<m){
            nums[k]=nums1[i];
            i++;
            k++;
        }
        while(j<n){
            nums[k]=nums2[j];
            j++;
            k++;
        }
        // copy merged array back into nums1
        for(int x=0;x<m+n;x++){
            nums1[x]=nums[x];
        }
    }
}
