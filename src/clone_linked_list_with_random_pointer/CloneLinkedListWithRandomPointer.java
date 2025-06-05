package clone_linked_list_with_random_pointer;
import java.util.HashMap;
import java.util.LinkedList;


public class CloneLinkedListWithRandomPointer {

    public static Node cloneLinkedListWithRandomPointerMap(Node head){
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null){
            Node clone = map.get(curr);
            clone.next = map.get(curr.next);
            clone.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);

    }

    public static Node cloneLinkedListWithRandomPointer(Node head) {
        if (head == null) return null;

        // Step 1: Clone each node and insert it right after the original node
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Step 2: Assign random pointers to the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate original and cloned lists
        Node original = head;
        Node cloneHead = head.next;
        Node clone = cloneHead;
        while (original != null) {
            original.next = original.next.next;
            clone.next = (clone.next != null) ? clone.next.next : null;
            original = original.next;
            clone = clone.next;
        }

        return cloneHead;


    }

}
