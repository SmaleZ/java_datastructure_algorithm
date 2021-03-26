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
			System.out.println("add: ��ӹ�Ա");
			System.out.println("list: ��ʾ��Ա");
			System.out.println("exit: �˳�");
			System.out.println("find: ����");
			System.out.println("delete: ɾ��");
			key = scanner.next();
			
			switch (key) {
			case "add":
				System.out.println("����id");
				int id = scanner.nextInt();
				System.out.println("��������");
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
				System.out.println("����Ҫ���ҵ�id");
				int target = scanner.nextInt();
				hashTab.findEmpById(target);
				break;
			case "delete":
				System.out.println("����Ҫɾ����id");
				int deleteid = scanner.nextInt();
				hashTab.deleteEmpById(deleteid);
				break;
			default:
				
				break;
			}
		}
		

	}

}

//����һ��HashTable �����������
class HashTab{
	 private EmpLinkedList[] empLinkedLists;
	 private int size;
	 
	 public HashTab(int size) {
		 //��ʼ��
		 this.size = size;
		 empLinkedLists = new EmpLinkedList[size];
		 //??��Ҫ���Ƿֱ��ʼ��ÿһ������
		 for (int i = 0; i < size; i++) {
			empLinkedLists[i] = new EmpLinkedList();
		}
	 }
	 
	 //add
	 public void add(Emp emp) {
		 //����Ա����id ȷ����ӵ���������
		 int empLinedListNo = hashFun(emp.id);
		 empLinkedLists[empLinedListNo].add(emp);
		 
	 }
	 
	 //list out
	 public void list() {
		 for (int i = 0; i < size; i++) {
			empLinkedLists[i].list(i);
		}
	 }
	 
	 //hash function, ʹ�ü򵥵�ȡģ��
	 public int hashFun(int id) {
		 return id % size;
	 }
	 
	 //���������id ���ҹ�Ա
	 public void findEmpById(int id){
		 int empLinedListNo = hashFun(id);
		 Emp emp = empLinkedLists[empLinedListNo].findEmpById(id);
		 if (emp != null) {
			System.out.printf("�ڵ�%d���������ҵ� ��Ա id = %d", empLinedListNo, id);
			System.out.println();
		 }else {
			System.out.println("û���ҵ�");
		}
	 }
	 
	 public void deleteEmpById(int id) {
		 int empLinedListNo = hashFun(id);
		 empLinkedLists[empLinedListNo].delete(id);
		 
	}
	 
}


//��ʾһ����Ա
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
	//ͷָ�룬ִ�е�һ��Emp, ���������������head ��ָ���һ��emp
	private Emp head;
	
	//add
	//������������, ����id ����������, ��id�ķ������Ǵ�С����
	//������ǽ��ù�Աֱ�Ӽӵ����������󼴿�
	public void add(Emp emp) {
		//�������ӵ�һ����Ա
		if (head == null) {
			head = emp;
			return;
		}
		//������ǵ�һ����Ա, ��ʹ��һ��������ָ�룬������λ�����
		Emp curEmp = head;
		
		while (true) {
			if (curEmp.nextEmp == null) {
				break;
			}
			curEmp = curEmp.nextEmp;
		}
		curEmp.nextEmp = emp;
	}
	
	//����id ɾ����Ա
	public void delete(int id) {
		if (head == null) {
			System.out.println("����Ϊ���޷�����ɾ��");
			return;
		}
		if (findEmpById(id) == null) {
			System.out.println("������û�и�Ԫ��, �޷�ɾ��");
			return;
		}
		
		Emp curEmp = head;
		Emp tEmp = head;
		while (true) {
			if (curEmp.nextEmp == null) {
				//Ҫ���ҵ��ڵ�һ��
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
			System.out.println("��" +no+ "����Ϊ��");
			return;
		}
		System.out.print("�� " +no+ " �������ϢΪ��");
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
			System.out.println("����Ϊ��");
			return null;
		}
		
		Emp currEmp = head;
		while (true) {
			if (currEmp.id == id) {
				break;
			}
			if (currEmp.nextEmp == null) {
				//û���ҵ�
				currEmp = null;
				break;
				
			}
			currEmp = currEmp.nextEmp;
		}
		
		return currEmp;
		
	}
}