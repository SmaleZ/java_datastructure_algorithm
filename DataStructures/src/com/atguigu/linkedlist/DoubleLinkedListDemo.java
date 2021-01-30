package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// test
		System.out.println("双向链表的测试");
		HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及時雨");
		HeroNode2 heroNode2 = new HeroNode2(2, "盧俊義", "玉麒麟");
		HeroNode2 heroNode3 = new HeroNode2(3, "吳用", "智多星");
		HeroNode2 heroNode4 = new HeroNode2(4, "林衝", "豹子頭");

		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//		doubleLinkedList.add(heroNode1);
//		doubleLinkedList.add(heroNode2);
//		doubleLinkedList.add(heroNode3);
//		doubleLinkedList.add(heroNode4);

//		doubleLinkedList.list();
//
//		HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
//		doubleLinkedList.update(newHeroNode);
//		System.out.println("修改后的");
//		doubleLinkedList.list();
//
//		doubleLinkedList.delete(3);
//		System.out.println("删除后的");
//		doubleLinkedList.list();

		doubleLinkedList.addByOrder(heroNode1);
		doubleLinkedList.addByOrder(heroNode4);
		doubleLinkedList.addByOrder(heroNode3);
		doubleLinkedList.addByOrder(heroNode2);
		doubleLinkedList.list();

	}

}

class DoubleLinkedList {
	private HeroNode2 head = new HeroNode2(0, "", "");

	// 显示链表
	public void list() {
		if (head.next == null) {
			System.out.println("list is empty!");
			return;
		}
		HeroNode2 tempHeroNode = head.next;
		while (true) {
			if (tempHeroNode == null) {
				break;
			}
			System.out.println(tempHeroNode);
			tempHeroNode = tempHeroNode.next;
		}
	}

	// add
	public void add(HeroNode2 heroNode) {
		// 1. find the tail of list
		// 2. point the next to the new node
		// 3. need a temp node to traverse
		HeroNode2 tempHeroNode = head;
		while (true) {
			if (tempHeroNode.next == null) {
				break;
			}
			tempHeroNode = tempHeroNode.next;
		}
		// 形成一个双向链表
		tempHeroNode.next = heroNode;
		heroNode.pre = tempHeroNode;
	}

	// add by the order of no.
	public void addByOrder(HeroNode2 heroNode) {
		HeroNode2 tempHeroNode = head;
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
			if (tempHeroNode.next != null) {
				tempHeroNode.next.pre = heroNode;
			}
			tempHeroNode.next = heroNode;
			heroNode.pre = tempHeroNode;
		}
	}

	// 修改，双向链表的内容修改和单向链表一样
	public void update(HeroNode2 heroNode) {
		// is empty
		if (head.next == null) {
			System.out.println("list is empty!");
			return;
		}
		HeroNode2 temHeroNode = head.next;
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

	// 删除一个节点
	public void delete(int no) {
		if (head.next == null) {
			System.out.println("链表为空，无法删除！");
		}
		HeroNode2 tempHeroNode = head.next;
		boolean alreadyfind = false;
		while (true) {
			if (tempHeroNode.next == null) {
				break;
			}
			if (tempHeroNode.no == no) {
				// find the task
				alreadyfind = true;
				break;
			}
			tempHeroNode = tempHeroNode.next;
		}

		if (alreadyfind) {
			tempHeroNode.pre.next = tempHeroNode.next;
			// 如果删除的不是最后一个节点
			if (tempHeroNode.next != null) {
				tempHeroNode.next.pre = tempHeroNode.pre;
			}
		} else {
			System.out.printf("the no. %d doesn't exist!\n", no);
		}

	}

}

class HeroNode2 {
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next; // 默认为null
	public HeroNode2 pre; // 默认为null

	// constructor
	public HeroNode2(int no, String name, String nickname) {
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
