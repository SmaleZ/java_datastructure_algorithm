package com.atguigu.tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		
		HeroNode root = new HeroNode(1, "�ν�");
		HeroNode node2 = new HeroNode(2, "����");
		HeroNode node3 = new HeroNode(3, "¬����");
		HeroNode node4 = new HeroNode(4, "�ֳ�");
		HeroNode node5 = new HeroNode(5, "��ʤ");
		HeroNode node6 = new HeroNode(6, "�ŷ�");
		HeroNode node7 = new HeroNode(7, "����");
		HeroNode node8 = new HeroNode(8, "����");
		HeroNode node9 = new HeroNode(9, "�����");
		//�ֶ�����,
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node6);
		node2.setRight(node7);
		node3.setRight(node4);
		node3.setLeft(node5);
		node4.setLeft(node8);
		node5.setLeft(node9);
		
		
		binaryTree.setRoot(root);
		//ǰ�����
		System.out.println("ǰ�����");	
		binaryTree.preOrder();
		
		//�������
		System.out.println("�������");
		binaryTree.infixOrder();
		
		//�������
		System.out.println("�������");
		binaryTree.postOrder();
		
		//ǰ�����
		System.out.println("ǰ�������ʽ~");
		HeroNode resHeroNode = binaryTree.preOrderSearch(5);
		if (resHeroNode != null) {
			System.out.printf("�ҵ��� ���Ϊ %d ����Ϊ %s �� Ӣ��", resHeroNode.getNo(), resHeroNode.getName());
		}else {
			System.out.printf("û���ҵ����Ϊ %d ��Ӣ��", 5);
		}
		//�������
		System.out.println("���������ʽ~");
		resHeroNode = binaryTree.infixOrderSearch(6);
		if (resHeroNode != null) {
			System.out.printf("�ҵ��� ���Ϊ %d ����Ϊ %s �� Ӣ��", resHeroNode.getNo(), resHeroNode.getName());
		}else {
			System.out.printf("û���ҵ����Ϊ %d ��Ӣ��", 6);
		}
		//�������
		System.out.println("���������ʽ~");
		resHeroNode = binaryTree.postOrderSearch(1);
		if (resHeroNode != null) {
			System.out.printf("�ҵ��� ���Ϊ %d ����Ϊ %s �� Ӣ��", resHeroNode.getNo(), resHeroNode.getName());
		}else {
			System.out.printf("û���ҵ����Ϊ %d ��Ӣ��", 1);
		}
		
		
		System.out.println("ɾ��ǰ��ǰ�����");
		binaryTree.preOrder();
		binaryTree.deNode(2);
		System.out.println("ɾ����ǰ�����");
		binaryTree.preOrder();
		
		System.out.println("����������ұ�ɾ���ڵ�");
		resHeroNode = binaryTree.postOrderSearch(2);
		if (resHeroNode != null) {
			System.out.printf("�ҵ��� ���Ϊ %d ����Ϊ %s �� Ӣ��", resHeroNode.getNo(), resHeroNode.getName());
		}else {
			System.out.printf("û���ҵ����Ϊ %d ��Ӣ��", 2);
		}
	}

}

class BinaryTree {
	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	public void deNode(int no) {
		if (root != null) {
			if (root.getNo() == no) {
				root = null;
			}else {
				root.delNode(no);
			}
		}else {
			System.out.println("���ڵ�Ϊ�գ��޷�ɾ��");
		}
	}

	// ǰ�����
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("������Ϊ��");
		}
	}

	// �������
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("������Ϊ��");
		}
	}

	// �������
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("������Ϊ��");
		}
	}
	
	//ǰ�����
	public HeroNode preOrderSearch (int no) {
		if (root != null) {
			return root.preOrderSearch(no);
		}else {
			return null;
		}
	}
	//�������
	public HeroNode infixOrderSearch (int no) {
		if (root != null) {
			return root.infixOrderSearch(no);
		}else {
			return null;
		}
	}
	//�������
	public HeroNode postOrderSearch (int no) {
		if (root != null) {
			return root.postOrderSearch(no);
		}else {
			return null;
		}
	}
}

class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;

	public HeroNode(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	
	//�ݹ�ɾ���ڵ�
	public void delNode(int no) {
		//�жϵ��Ǹýڵ���ӽڵ��Ƿ�ΪҪɾ���Ľڵ㣬�����Ǹýڵ�
		//�ж���ڵ��Ƿ�Ϊ�ն����Ƿ�ΪҪɾ���Ľڵ�
		//�����Ҷ�ӽڵ㣬��ֱ��ɾ���� ����Ƿ�Ҷ�ӽڵ�
		//���øýڵ���ӽڵ��滻����ڵ㣬Ȼ�󽫸ýڵ�ɾ��
		//����������ӽڵ㣬������ڵ��滻
		if (this.left != null && this.left.getNo() == no) {
			if (this.left.left != null && this.left.right != null) {
				//�������ӽڵ�
				HeroNode tempHeroNode = this.left;
				this.left = tempHeroNode.left;
				this.left.right = tempHeroNode.right;
				tempHeroNode = null;
			}
			else if (this.left.left != null && this.left.right == null) {
				//ֻ�����ӽڵ�
				HeroNode tempHeroNode = this.left;
				this.left = tempHeroNode.left;
				tempHeroNode = null;
			}
			else if (this.left.left == null && this.left.right != null) {
				//ֻ�����ӽڵ�
				HeroNode tempHeroNode = this.left;
				this.left = tempHeroNode.right;
				tempHeroNode = null;
			}else {
				this.left = null;
			}
			return;
		}
		//�ж��ҽڵ��Ƿ�Ϊ�ն����Ƿ�ΪҪɾ���Ľڵ�
		if (this.right != null && this.right.getNo() == no) {
			if (this.right.left != null && this.right.right != null) {
				HeroNode tempHeroNode = this.right;
				this.right = tempHeroNode.left;
				this.right.right = tempHeroNode.right;
				tempHeroNode = null;
			}
			else if (this.right.left != null && this.right.right == null) {
				HeroNode tempHeroNode = this.right;
				this.right = tempHeroNode.left;
				tempHeroNode = null;
			}
			else if (this.right.left == null && this.right.right != null) {
				HeroNode tempHeroNode = this.right;
				this.right = tempHeroNode.right;
				tempHeroNode = null;
			}else {
				this.right = null;
			}
			return;
		}
		//�������������û��ɾ���������������ݹ�
		if (this.left != null) {
			this.left.delNode(no);
		}
		//�������������û��ɾ���������������ݹ�
		if (this.right != null) {
			this.right.delNode(no);
		}
	}

	// ǰ������ķ���
	public void preOrder() {
		System.out.println(this);// ��������ڵ�
		// ������������
		if (this.left != null) {
			this.left.preOrder();
		}
		// ������������
		if (this.right != null) {
			this.right.preOrder();
		}

	}

	// �������

	public void infixOrder() {
		// ������
		if (this.left != null) {
			this.left.infixOrder();
		}

		// ���ڵ�
		System.out.println(this);

		// ������

		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	// �������
	public void postOrder() {
		// ������
		if (this.left != null) {
			this.left.postOrder();
		}
		// ������
		if (this.right != null) {
			this.right.postOrder();
		}
		// ���ڵ�
		System.out.println(this);
	}

	//ǰ���������
	public HeroNode preOrderSearch(int no) {
		if (this.no == no) {
			return this;
		}
		//�жϵ�ǰ�ڵ����ڵ��Ƿ�Ϊ�գ������Ϊ����ݹ�ǰ�����
		//�����ݹ�ǰ������ҵ��ˣ��򷵻�
		HeroNode resHeroNode = null;
		if (this.left != null) {
			resHeroNode = this.left.preOrderSearch(no);
		}
		if (resHeroNode != null) {
			return resHeroNode;
		}
		
		if (this.right != null) {
			resHeroNode = this.right.preOrderSearch(no);
		}
		return resHeroNode;
	}
	//�����������
	public HeroNode infixOrderSearch(int no) {
		HeroNode resHeroNode = null;
		if (this.left != null) {
			resHeroNode = this.left.infixOrderSearch(no);
		}
		if (resHeroNode != null) {
			return resHeroNode; 
		}
		
		if (this.no == no) {
			return this;
		}
		if (this.right != null) {
			resHeroNode = this.right.infixOrderSearch(no);
		}
		return resHeroNode;
	}
	//�����������
	public HeroNode postOrderSearch(int no) {
		HeroNode resHeroNode = null;
		if (this.left != null) {
			resHeroNode = this.left.postOrderSearch(no);
		}
		
		if (resHeroNode != null) {
			return resHeroNode;
		}
		
		if (this.right != null) {
			resHeroNode = this.right.postOrderSearch(no);
		}
		if (resHeroNode != null) {
			return resHeroNode;
		}
		
		if (this.no == no) {
			return this;
		}
		return resHeroNode;
	}
}
