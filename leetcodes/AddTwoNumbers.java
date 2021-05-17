import java.util.Collections;
import java.util.LinkedList;

/**
 * 두 개의 ListNode를 입력받아 ListNode의 Leaf Node부터 parent Node의 수를 더하는 문제
 * EX) l1 : [ 2, 4, 9 ], l2 : [ 5, 6, 4, 9 ] 라면
 * ==> 942 + 9465 = 10407 을 다시 reverse하여 ListNode 반환
 */


class ListNode {
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

public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    // 입력받은 ListNode를 LinkedList로 변환하여 반환
		LinkedList<Integer> numbers1 = getLinkedList(l1);
		LinkedList<Integer> numbers2 = getLinkedList(l2);

		int max = Math.max(numbers1.size(), numbers2.size());

    // 두 리스트가 동일한 사이즈를 가지도록 padding을 추가
		addPadding(numbers1, max);
		addPadding(numbers2, max);

		int up = 0;
		ListNode result = new ListNode();
		ListNode next = result;

		for (int i = max - 1; i >= 0; i--) {
			int sum = up + numbers1.get(i) + numbers2.get(i);
			up = sum / 10;
			next.val = sum % 10;
			if (i != 0) {
				next.next = new ListNode();
				next = next.next;
			} else if (up != 0) {
				next.next = new ListNode(up);
			}
		}

		return result;
	}

	private static void addPadding(LinkedList<Integer> numbers1, int max) {
		int gap1 = max - numbers1.size();
		while (gap1 > 0) {
			numbers1.addFirst(0);
			gap1 -= 1;
		}
	}

	private static LinkedList<Integer> getLinkedList(ListNode l1) {
		LinkedList<Integer> numbers = new LinkedList<>();
		ListNode temp = l1;
		while (temp != null) {
			numbers.add(temp.val);
			temp = temp.next;
		}
		Collections.reverse(numbers);

		return numbers;
	}
}
