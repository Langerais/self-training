package clone_linked_list_with_random_pointer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class CloneLinkedListWithRandomPointerTest {

    // Helper to convert linked list from head to List<Node>
    private List<Node> toList(Node head) {
        List<Node> result = new ArrayList<>();
        while (head != null) {
            result.add(head);
            head = head.next;
        }
        return result;
    }

    // Helper to assign random pointers by indices
    private void setRandomPointers(List<Node> nodes, int[] randomIndices) {
        for (int i = 0; i < nodes.size(); i++) {
            int idx = randomIndices[i];
            nodes.get(i).random = (idx == -1) ? null : nodes.get(idx);
        }
    }

    // Helper to validate the deep clone list structure
    private void assertClonedListCorrect(List<Node> original, List<Node> cloned) {
        assertEquals(original.size(), cloned.size(), "List sizes differ");

        for (int i = 0; i < original.size(); i++) {
            Node orig = original.get(i);
            Node copy = cloned.get(i);

            assertEquals(orig.val, copy.val, "Node value mismatch at index " + i);
            assertNotSame(orig, copy, "Node should be a new instance at index " + i);

            Integer expectedRandomVal = (orig.random == null) ? null : orig.random.val;
            Integer actualRandomVal = (copy.random == null) ? null : copy.random.val;
            assertEquals(expectedRandomVal, actualRandomVal, "Random pointer value mismatch at index " + i);
        }
    }

    @Test
    public void testEmptyList() {
        Node head = null;
        Node cloned = CloneLinkedListWithRandomPointer.cloneLinkedListWithRandomPointer(head);
        assertNull(cloned, "Cloned list should be null");
    }

    @Test
    public void testSingleNodeNoRandom() {
        Node head = new Node(1);
        Node cloned = CloneLinkedListWithRandomPointer.cloneLinkedListWithRandomPointer(head);

        assertNotNull(cloned);
        assertEquals(1, cloned.val);
        assertNull(cloned.random);
        assertNull(cloned.next);
        assertNotSame(head, cloned);
    }

    @Test
    public void testSingleNodeWithRandomToSelf() {
        Node head = new Node(42);
        head.random = head;

        Node cloned = CloneLinkedListWithRandomPointer.cloneLinkedListWithRandomPointer(head);
        assertNotNull(cloned);
        assertEquals(42, cloned.val);
        assertNotSame(head, cloned);
        assertSame(cloned, cloned.random, "Random pointer should point to self");
    }

    @Test
    public void testMultipleNodesWithVariousRandoms() {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        n1.next = n2; n2.next = n3;

        List<Node> original = List.of(n1, n2, n3);
        setRandomPointers(original, new int[]{2, 0, -1}); // n1.random -> n3, n2.random -> n1, n3.random -> null

        Node clonedHead = CloneLinkedListWithRandomPointer.cloneLinkedListWithRandomPointer(n1);
        List<Node> cloned = toList(clonedHead);

        assertClonedListCorrect(original, cloned);
    }

    @Test
    public void testAllRandomsNull() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2; n2.next = n3;

        List<Node> original = List.of(n1, n2, n3);
        setRandomPointers(original, new int[]{-1, -1, -1});

        Node clonedHead = CloneLinkedListWithRandomPointer.cloneLinkedListWithRandomPointer(n1);
        List<Node> cloned = toList(clonedHead);

        assertClonedListCorrect(original, cloned);
    }

    @Test
    public void testAllRandomsToNext() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2; n2.next = n3;

        List<Node> original = List.of(n1, n2, n3);
        setRandomPointers(original, new int[]{1, 2, -1});

        Node clonedHead = CloneLinkedListWithRandomPointer.cloneLinkedListWithRandomPointer(n1);
        List<Node> cloned = toList(clonedHead);

        assertClonedListCorrect(original, cloned);
    }
}
