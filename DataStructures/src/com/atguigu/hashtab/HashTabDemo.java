package com.atguigu.hashtab;

import java.util.Scanner;


public class HashTabDemo {

	public static void main(String[] args) {
		//create a hash table
		HashTab hashTab = new HashTab(7);
		
		//menue
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("add: 添加雇员");
			System.out.println("list: 显示雇员");
			System.out.println("exit: 退出");
			System.out.println("find: 查找");
			System.out.println("delete: 删除");
			key = scanner.next();
			
			switch (key) {
			case "add":
				System.out.println("输入id");
				int id = scanner.nextInt();
				System.out.println("输入名字");
				String name = scanner.next();
				
				Emp emp = new Emp(id, name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "exit":
				scanner.close();
				System.exit(0);
				break;
			case "find":
				System.out.println("输入要查找的id");
				int target = scanner.nextInt();
				hashTab.findEmpById(target);
				break;
			case "delete":
				System.out.println("输入要删除的id");
				int deleteid = scanner.nextInt();
				hashTab.deleteEmpById(deleteid);
				break;
			default:
				
				break;
			}
		}
		

	}

}

//创建一个HashTable 管理多条链表
class HashTab{
	 private EmpLinkedList[] empLinkedLists;
	 private int size;
	 
	 public HashTab(int size) {
		 //初始化
		 this.size = size;
		 empLinkedLists = new EmpLinkedList[size];
		 //??不要忘记分别初始化每一条链表
		 for (int i = 0; i < size; i++) {
			empLinkedLists[i] = new EmpLinkedList();
		}
	 }
	 
	 //add
	 public void add(Emp emp) {
		 //根据员工的id 确定添加到哪条链表
		 int empLinedListNo = hashFun(emp.id);
		 empLinkedLists[empLinedListNo].add(emp);
		 
	 }
	 
	 //list out
	 public void list() {
		 for (int i = 0; i < size; i++) {
			empLinkedLists[i].list(i);
		}
	 }
	 
	 //hash function, 使用简单的取模法
	 public int hashFun(int id) {
		 return id % size;
	 }
	 
	 //根据输入的id 查找雇员
	 public void findEmpById(int id){
		 int empLinedListNo = hashFun(id);
		 Emp emp = empLinkedLists[empLinedListNo].findEmpById(id);
		 if (emp != null) {
			System.out.printf("在第%d条链表中找到 雇员 id = %d", empLinedListNo, id);
			System.out.println();
		 }else {
			System.out.println("没有找到");
		}
	 }
	 
	 public void deleteEmpById(int id) {
		 int empLinedListNo = hashFun(id);
		 empLinkedLists[empLinedListNo].delete(id);
		 
	}
	 
}


//表示一个雇员
class Emp{
	public int id;
	public String name;
	public Emp nextEmp;
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}


class EmpLinkedList{
	//头指针，执行第一个Emp, 因此我们这个链表的head 是指向第一个emp
	private Emp head;
	
	//add
	//加在链表的最后, 假设id 是自增长的, 即id的分配总是从小到大
	//因此我们将该雇员直接加到本链表的最后即可
	public void add(Emp emp) {
		//如果是添加第一个雇员
		if (head == null) {
			head = emp;
			return;
		}
		//如果不是第一个雇员, 则使用一个辅助的指针，帮助定位到最后
		Emp curEmp = head;
		
		while (true) {
			if (curEmp.nextEmp == null) {
				break;
			}
			curEmp = curEmp.nextEmp;
		}
		curEmp.nextEmp = emp;
	}
	
	//根据id 删除雇员
	public void delete(int id) {
		if (head == null) {
			System.out.println("链表为空无法继续删除");
			return;
		}
		if (findEmpById(id) == null) {
			System.out.println("链表中没有该元素, 无法删除");
			return;
		}
		
		Emp curEmp = head;
		Emp tEmp = head;
		while (true) {
			if (curEmp.nextEmp == null) {
				//要查找的在第一个
				head = null;
				break;
			}
			else if (curEmp.nextEmp.id == id) {
				curEmp.nextEmp = curEmp.nextEmp.nextEmp;
				
				break;
			}
			curEmp = curEmp.nextEmp;
		}
		
		
	}
	
	public void list(int no) {
		if (head == null) {
			System.out.println("第" +no+ "链表为空");
			return;
		}
		System.out.print("第 " +no+ " 链表的信息为：");
		Emp curEmp = head;
		while (true) {
			System.out.printf("=> id=%d name=%s \t", curEmp.id, curEmp.name);
			if (curEmp.nextEmp == null) {
				break;
			}
			curEmp = curEmp.nextEmp;
		}
		System.out.println();
	}
	
	public Emp findEmpById(int id) {
		if (head == null) {
			System.out.println("链表为空");
			return null;
		}
		
		Emp currEmp = head;
		while (true) {
			if (currEmp.id == id) {
				break;
			}
			if (currEmp.nextEmp == null) {
				//没有找到
				currEmp = null;
				break;
				
			}
			currEmp = currEmp.nextEmp;
		}
		
		return currEmp;
		
	}
}