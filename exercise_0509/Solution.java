package exercise.exercise_0509;

/*
18. 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：
答案中不可以包含重复的四元组。
示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0,len=nums.length; i<len-3; i++){
            if(i==0 ||(i>0 && nums[i] !=nums[i-1])){//跳过重复的
                for(int j=i+1; j<len-2; j++){
                    if(j==i+1|| j>i+1 && nums[j] != nums[j-1]){//跳过重复的
                        int temp = target-nums[i]-nums[j];
                        int l=j+1;
                        int r=len-1;
                        while(l < r){
                            if(nums[l] +nums[r] == temp){
                                List<Integer> list = new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[l]);
                                list.add(nums[r]);
                                result.add(list);
                                l++;
                                r--;
                                while(l<r && nums[l] == nums[l-1]){
                                    l++;
                                }
                                while(l<r && nums[r] == nums[r+1]){
                                    r--;
                                }
                            }else if(nums[l] +nums[r] < temp){
                                l++;
                                while(l<r && nums[l] == nums[l-1]){
                                    l++;
                                }
                            }else{
                                r--;
                                while(l<r && nums[r] == nums[r+1]){
                                    r--;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}



/*
19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：
给定的 n 保证是有效的。
进阶：
你能尝试使用一趟扫描实现吗？
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n<=0){
            return null;
        }
        //找到要删除节点的前驱节点
        n++;
        ListNode fastNode = head;
        ListNode slowNode = head;
        for(int i=0; i<n; i++){
            if(fastNode == null){
                if(i == n-1){//最后一步，说明要删除的是头结点
                    head = head.next;
                    return head;
                }else{//删除的节点不存在
                    return null;
                }
            }
            fastNode = fastNode.next;
        }
        while(fastNode != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return head;
    }
}*/

/*
24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:
给定 1->2->3->4, 你应该返回 2->1->4->3.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode node = head;
        ListNode tmp = node.next;
        node.next = node.next.next;
        tmp.next = node;
        head = tmp;
        ListNode before = node;
        node = node.next;
        while(node != null && node.next != null){
            tmp = node.next;
            node.next = node.next.next;//删除右边的节点
            tmp.next = node;//前插
            before.next = tmp;//连接前面
            before = node;//更新
            node = node.next;
        }
        return head;
    }
}*/
