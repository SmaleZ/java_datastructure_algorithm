package com.atguigu.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// test
		// create nodes
		HeroNode heroNode1 = new HeroNode(1, "宋江", "及時雨");
		HeroNode heroNode2 = new HeroNode(2, "盧俊義", "玉麒麟");
		HeroNode heroNode3 = new HeroNode(3, "吳用", "智多星");
		HeroNode heroNode4 = new HeroNode(4, "林衝", "豹子頭");
		
		HeroNode heroNode5 = new HeroNode(5, "张五", "五");
		HeroNode heroNode6 = new HeroNode(6, "张六", "六");
		HeroNode heroNode7 = new HeroNode(7, "章七", "七");
		HeroNode heroNode8 = new HeroNode(8, "李八", "八");
		HeroNode heroNode9 = new HeroNode(9, "王九", "九");

		SingleLinkedList singleLinkedList1 = new SingleLinkedList();
		SingleLinkedList singleLinkedList2 = new SingleLinkedList();
		SingleLinkedList singleLinkedList3 = new SingleLinkedList();
//		singleLinkedList.add(heroNode1);
//		singleLinkedList.add(heroNode2);
//		singleLinkedList.add(heroNode3);
//		singleLinkedList.add(heroNode4);

		singleLinkedList1.addByOrder(heroNode1);
		singleLinkedList1.addByOrder(heroNode4);
		singleLinkedList1.addByOrder(heroNode2);
		singleLinkedList1.addByOrder(heroNode5);
		singleLinkedList1.list();
		
		System.out.println();
		
		singleLinkedList2.addByOrder(heroNode3);
		singleLinkedList2.addByOrder(heroNode6);
		singleLinkedList2.addByOrder(heroNode7);
		singleLinkedList2.addByOrder(heroNode8);
		singleLinkedList2.addByOrder(heroNode9);
		singleLinkedList2.list();
		
		System.out.println();
		
		singleLinkedList3.setHead(unifyList(singleLinkedList1.getHead(), singleLinkedList2.getHead()));
		singleLinkedList3.list();
		
		

//		HeroNode newhHeroNode = new HeroNode(2, "XIAOLU", "XIAOYU");
//		singleLinkedList1.update(newhHeroNode);
//		System.out.println("after updating");
//		singleLinkedList1.list();
//
//		// delete a node;
//		singleLinkedList1.delete(1);
//		System.out.println("after updating");
//		singleLinkedList1.list();

	}

	/**
	 * 
	 * @param head head node
	 * @return number of node
	 */
	public static int getLength(HeroNode head) {
		if (head.next == null) {
			return 0;
		}
		int length = 0;
		HeroNode curr = head.next;
		while (curr != null) {
			length++;
			curr = curr.next;
		}
		return length;
	}

	// 查找单链表中的倒数第k个结点；
	// 思路：
	// 1. 编写一个方法， 接受head 节点，同时接受一个index
	// 2. index 表示倒数第index个结点
	// 3. 先得到总的长度，然后 从头遍历 （size - index）个
	//
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		if (head.next == null) {
			return null;
		}
		int size = getLength(head);
		if (index <= 0 || index > size) {
			return null;
		}
		HeroNode curr = head.next;
		for (int i = 0; i < size - index; i++) {
			curr = curr.next;
		}
		return curr;
	}

	// 将单链表反转
	public static void reverseList(HeroNode head) {
		// 如果当前链表为空或者只有一个节点，无需反转
		if (head.next == null || head.next.next == null) {
			return;
		}

		// 定义一个辅助变量
		HeroNode curr = head.next;
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode(0, "", "");
		while (curr != null) {
			next = curr.next; // 先暂时保存当前节点的下一个节点
			curr.next = reverseHead.next; // 将curr 摘下并连zai新的反转链表的下一个
			reverseHead.next = curr; // 将curr 加入新链表
			curr = next;
		}
		// 将 head.next 指向 reverseHead.next
		head.next = reverseHead.next;
	}

	// 将单链表逆序打印
	// 使用栈来逆序打印
	public static void reversePrint(HeroNode head) {
		if (head.next == null) {
			return;
		}
		// 创建一个栈，将各个节点压入栈中
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode curr = head.next;
		while (curr != null) {
			stack.push(curr);
			curr = curr.next;
		}
		// 将栈中的节点进行打印
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

	// 将俩个有序单链表合并
	public static HeroNode unifyList(HeroNode head1, HeroNode head2) {
		if (head1.next == null && head2.next == null) {
			return null;
		}
		if (head1.next == null && head2.next != null) {
			return head2;
		}
		if (head2.next == null && head1.next != null) {
			return head1;
		}
		HeroNode crr1 = head1.next;
		HeroNode crr2 = head2.next;
		HeroNode next1 = null;
		HeroNode next2 = null;
		HeroNode unifiedHead = new HeroNode(0, "", "");
		HeroNode temp = unifiedHead;

		while (crr1 != null && crr2 != null) {
			if (crr1.no <= crr2.no) {
				next1 = crr1.next;
				crr1.next = temp.next;
				temp.next = crr1;
				crr1 = next1;
				temp = temp.next;
			} else {
				next2 = crr2.next;
				crr2.next = temp.next;
				temp.next = crr2;
				crr2 = next2;
				temp = temp.next;
			}
		}

		if (crr1 != null && crr2 == null) {
			temp.next = crr1;
			head1.next = unifiedHead.next;
			return head1;
		} else {
			temp.next = crr2;
			head2.next = unifiedHead.next;
			return head2;
		}
	}
}

//define a single linked list
class SingleLinkedList {
	// initialize a head node
	private HeroNode head = new HeroNode(0, "", "");

	// return head node
	public HeroNode getHead() {
		return head;
	}
	

	public void setHead(HeroNode head) {
		this.head = head;
	}


	// add node to linked list
	public void add(HeroNode heroNode) {
		// 1. find the tail of list
		// 2. point the next to the new node
		// 3. need a temp node to traverse
		HeroNode tempHeroNode = head;
		while (true) {
			if (tempHeroNode.next == null) {
				break;
			}
			tempHeroNode = tempHeroNode.next;
		}
		tempHeroNode.next = heroNode;
	}

	// show the list
	public void list() {
		if (head.next == null) {
			System.out.println("list is empty!");
			return;
		}
		HeroNode tempHeroNode = head.next;
		while (true) {
			if (tempHeroNode == null) {
				break;
			}
			System.out.println(tempHeroNode);
			tempHeroNode = tempHeroNode.next;
		}
	}

	// add by the order of no.
	public void addByOrder(HeroNode heroNode) {
		HeroNode tempHeroNode = head;
		boolean alreadayexist = false; //
		while (true) {
			if (tempHeroNode.next == null) {
				break;
			}
			if (tempHeroNode.next.no > heroNode.no) {
				break;
			} else if (tempHeroNode.no == heroNode.no) {
				alreadayexist = true;
				break;
			}
			tempHeroNode = tempHeroNode.next;
		}
		if (alreadayexist) {
			System.out.printf("the hero %d already exist", heroNode.no);
		} else {
			heroNode.next = tempHeroNode.next;
			tempHeroNode.next = heroNode;
		}
	}

	// change the data of node but do not change no.
	public void update(HeroNode heroNode) {
		// is empty
		if (head.next == null) {
			System.out.println("list is empty!");
			return;
		}
		HeroNode temHeroNode = head.next;
		boolean alreadyfind = false;
		while (true) {
			if (temHeroNode == null) {
				break;
			}
			if (temHeroNode.no == heroNode.no) {
				alreadyfind = true;
				break;
			}
			temHeroNode = temHeroNode.next;
		}
		if (alreadyfind) {
			temHeroNode.name = heroNode.name;
			temHeroNode.nickName = heroNode.nickName;
		} else {
			System.out.printf("did not find no.%d node", heroNode.no);
		}
	}

	// delete the node
	public void delete(int no) {
		HeroNode tempHeroNode = head;
		boolean alreadyfind = false;
		while (true) {
			if (tempHeroNode.next == null) {
				break;
			}
			if (tempHeroNode.next.no == no) {
				// find the task
				alreadyfind = true;
				break;
			}
			tempHeroNode = tempHeroNode.next;
		}

		if (alreadyfind) {
			tempHeroNode.next = tempHeroNode.next.next;
		} else {
			System.out.printf("the no. %d doesn't exist!\n", no);
		}

	}

}

class HeroNode {
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;

	// constructor
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickName = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}

	// overwrite toString

}