package com.data.division;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {

    /*
    在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

    示例 1:

        输入: [3,2,1,5,6,4] 和 k = 2
        输出: 5
    示例 2:

        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
        输出: 4
     */

  //快排 nlogn
  //维护为k的大顶堆
  //分治算法


  //大顶堆实现
  public int findKthLargest(int[] nums, int k) {

    //默认小顶堆
    PriorityQueue<Integer> heap = new PriorityQueue<>(k);

    for (int num : nums) {
      heap.add(num);
      if (heap.size() > k) {
        heap.poll();
      }
    }
    return heap.poll();
  }

  /*
    大顶堆
   */

  public int findKthLittlest(int [] nums,int k){

    PriorityQueue<Integer> heap=new PriorityQueue<>(k, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    });

    for (int num:nums){
      heap.add(num);
      if(heap.size()>k){
        heap.poll();
      }
    }
    return  heap.poll();

  }


  public void quickSort(int[] a, int low, int high) {

    int l = low;
    int h = high;
    int key = a[l];
    while (l < h) {
      while (l < h && a[h] > key) {
        h--;
      }
      if (l < h) {
        a[l] = a[h];
      }
      while (l < h && a[l] < key) {
        l++;
      }
      if (l < h) {

        a[h] = a[l];
      }
    }

    a[l] = key;

    if (low < l - 1) {
      quickSort(a, low, l - 1);
    }
    if (h + 1 < high) {
      quickSort(a, h + 1, high);
    }

  }

  int findKthLargest(int nums[], int k) {
    int low = 0, high = nums.size() - 1, mid = 0;
    while (low <= high) {
      mid = patition(nums, low, high);
      if (mid == k - 1) return nums[mid];
      else if (mid > k - 1) high = mid - 1;
      else low = mid + 1;
    }
    //  实际上返回 -1 代表没有第 k 大的数，这里不存在
    return -1;
  }

  int patition(int nums[], int low, int high) {
    int left = low + 1, right = high;
    swap(nums[low], nums[(low + high) / 2]);
    int bound = nums[low];
    //  双指针，快速排序，交换不符合条件的数据
    while (left <= right) {
      while (left < high && nums[left] >= bound) left++;
      while (nums[right] < bound) right--;
      if (left < right)
        swap(nums[left++], nums[right--]);
      else break;
    }
    //  将bound放到换分完成后的两个数组之间，作为边界, 返回bound的位次
    swap(nums[low], nums[right]);
    return right;
  }


  public int findKlargest(int[] nums, int k) {

    return 0;
  }


  public static void main(String[] args) {

    int nums[] = {3, 2, 1, 5, 6, 4};
    int k = 2;

    FindKthLargest fkl = new FindKthLargest();

    System.out.println(fkl.findKthLargest(nums, k)+"  第二大的数");

    System.out.println(fkl.findKthLittlest(nums,k)+"  第二小的数");

    //fkl.quickSort(nums, 0, nums.length - 1);

    System.out.println(nums[nums.length - 2]);



  }
}
