package easy;

import java.util.LinkedList;

public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        var rt = new LinkedList<Integer>();

        while (true) {

            if (list1.val < list2.val) {
                // avanzamos L1
                rt.add(list1.val);
                list1 = list1.next;
                if (list1 == null) {
                    while (list2 != null) {
                        rt.add(list2.val);
                        list2 = list2.next;
                    }
                    break;
                }
            } else {
                // avanzamos L2
                rt.add(list2.val);
                list2 = list2.next;
                if (list2 == null) {
                    while (list1 != null) {
                        rt.add(list1.val);
                        list1 = list1.next;
                    }
                    break;
                }
            }
        }

        var r = new ListNode();
        var head = r;
        if (!rt.isEmpty()) {
            r.val = rt.pop();
            while (!rt.isEmpty()) {
                r.next = new ListNode(rt.pop());
                r = r.next;
            }
        }
        return head;
    }
}
