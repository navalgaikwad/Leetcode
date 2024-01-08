}else{
dm.next = right;
right = right.next;
}
dm = dm.next;
}
dm.next = (left == null) ? right : left;
return temp.next;
}
private ListNode middle(ListNode head){
ListNode slow = head;
ListNode fast = head;
ListNode prev = null;
while(fast !=null && fast.next != null){
prev = slow;
slow = slow.next;
fast = fast.next.next;
}
// if(prev != null){
//     prev.next = null;
// }
return prev;
}
}