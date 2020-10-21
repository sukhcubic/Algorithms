import java.util.PriorityQueue;
//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthElementQuickSelectREVISIT {

//o(n) best case
    static int quickSelect(int[] nums, int k){
        if(nums.length<k){
            return -1;
        }
        int hi = nums.length-1;
        return sortHelper(0, hi, nums, k);
    }

    static int sortHelper(int lo, int hi ,int[] nums, int k){

        if(lo == hi){
            return nums[lo];
        }
          int partion = partition(nums, lo, hi);
          if(partion == k){
              return nums[k];
          }else if(partion>k){
              return sortHelper(lo, partion-1, nums, k);
          }else{
              return sortHelper(partion+1, hi, nums, k);
          }

    }

    static int partition(int[] list, int lo, int hi){
        int pivot = list[hi];
        int j = lo;
        for (int i = lo; i < hi; i++) {
            if(list[i]< pivot){
                swap(list,i, j);
                j++;
            }
        }
        swap(list, j, hi);
        return j;
    }

    private static void swap(int[] a, int i, int j){
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    //Second version. O(nlogn)
    int priorityQueue(int[] nums, int k){
        PriorityQueue<Integer> queue= new PriorityQueue<>((n1, n2) -> n1 - n2);

        //This is based on min prioroty queue. Min will stay at tail and max will stay at head. If size go up than k
        // remove lement to keep size at  k. Once done remove last which will be K = 2
        //3->2->1 add 5 = 5->3->2->1 poll() will give 3->2->1 and finally remove 3 whick is k(3rd largest 0 based index)
        for (int i:nums) {
            queue.add(i);
            if(queue.size()>k){
                queue.poll();
            }
        }

        return queue.poll();
    }

    public static void main(String arg[]){
        int[] nums = {15,   4,  7, 11, 5};

        System.out.println(quickSelect(nums, 1));
        }

}

