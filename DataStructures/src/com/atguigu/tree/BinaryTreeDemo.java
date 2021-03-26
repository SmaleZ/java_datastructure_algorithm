package com.atguigu.tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		
		HeroNode root = new HeroNode(1, "宋江");
		HeroNode node2 = new HeroNode(2, "吴用");
		HeroNode node3 = new HeroNode(3, "卢俊义");
		HeroNode node4 = new HeroNode(4, "林冲");
		HeroNode node5 = new HeroNode(5, "关胜");
		HeroNode node6 = new HeroNode(6, "张飞");
		HeroNode node7 = new HeroNode(7, "关羽");
		HeroNode node8 = new HeroNode(8, "赵云");
		HeroNode node9 = new HeroNode(9, "孙悟空");
		//手动创建,
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node6);
		node2.setRight(node7);
		node3.setRight(node4);
		node3.setLeft(node5);
		node4.setLeft(node8);
		node5.setLeft(node9);
		
		
		binaryTree.setRoot(root);
		//前序遍历
		System.out.println("前序遍历");	
		binaryTree.preOrder();
		
		//中序遍历
		System.out.println("中序遍历");
		binaryTree.infixOrder();
		
		//后序遍历
		System.out.println("后序遍历");
		binaryTree.postOrder();
		
		//前序查找
		System.out.println("前序遍历方式~");
		HeroNode resHeroNode = binaryTree.preOrderSearch(5);
		if (resHeroNode != null) {
			System.out.printf("找到了 编号为 %d 姓名为 %s 的 英雄", resHeroNode.getNo(), resHeroNode.getName());
		}else {
			System.out.printf("没有找到编号为 %d 的英雄", 5);
		}
		//中序查找
		System.out.println("中序遍历方式~");
		resHeroNode = binaryTree.infixOrderSearch(6);
		if (resHeroNode != null) {
			System.out.printf("找到了 编号为 %d 姓名为 %s 的 英雄", resHeroNode.getNo(), resHeroNode.getName());
		}else {
			System.out.printf("没有找到编号为 %d 的英雄", 6);
		}
		//后序查找
		System.out.println("后序遍历方式~");
		resHeroNode = binaryTree.postOrderSearch(1);
		if (resHeroNode != null) {
			System.out.printf("找到了 编号为 %d 姓名为 %s 的 英雄", resHeroNode.getNo(), resHeroNode.getName());
		}else {
			System.out.printf("没有找到编号为 %d 的英雄", 1);
		}
		
		
		System.out.println("删除前，前序遍历");
		binaryTree.preOrder();
		binaryTree.deNode(2);
		System.out.println("删除后，前序遍历");
		binaryTree.preOrder();
		
		System.out.println("后序遍历查找被删除节点");
		resHeroNode = binaryTree.postOrderSearch(2);
		if (resHeroNode != null) {
			System.out.printf("找到了 编号为 %d 姓名为 %s 的 英雄", resHeroNode.getNo(), resHeroNode.getName());
		}else {
			System.out.printf("没有找到编号为 %d 的英雄", 2);
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
			System.out.println("根节点为空，无法删除");
		}
	}

	// 前序遍历
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("二叉树为空");
		}
	}

	// 中序遍历
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("二叉树为空");
		}
	}

	// 后序遍历
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("二叉树为空");
		}
	}
	
	//前序查找
	public HeroNode preOrderSearch (int no) {
		if (root != null) {
			return root.preOrderSearch(no);
		}else {
			return null;
		}
	}
	//中序查找
	public HeroNode infixOrderSearch (int no) {
		if (root != null) {
			return root.infixOrderSearch(no);
		}else {
			return null;
		}
	}
	//后序查找
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
	
	//递归删除节点
	public void delNode(int no) {
		//判断的是该节点的子节点是否为要删除的节点，而不是该节点
		//判断左节点是否为空而且是否为要删除的节点
		//如果是叶子节点，则直接删除， 如果是非叶子节点
		//则将用该节点的子节点替换这个节点，然后将该节点删除
		//如果有两个子节点，则用左节点替换
		if (this.left != null && this.left.getNo() == no) {
			if (this.left.left != null && this.left.right != null) {
				//有两个子节点
				HeroNode tempHeroNode = this.left;
				this.left = tempHeroNode.left;
				this.left.right = tempHeroNode.right;
				tempHeroNode = null;
			}
			else if (this.left.left != null && this.left.right == null) {
				//只有左子节点
				HeroNode tempHeroNode = this.left;
				this.left = tempHeroNode.left;
				tempHeroNode = null;
			}
			else if (this.left.left == null && this.left.right != null) {
				//只有右子节点
				HeroNode tempHeroNode = this.left;
				this.left = tempHeroNode.right;
				tempHeroNode = null;
			}else {
				this.left = null;
			}
			return;
		}
		//判断右节点是否为空而且是否为要删除的节点
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
		//如果上面两步都没有删除，则向左子树递归
		if (this.left != null) {
			this.left.delNode(no);
		}
		//如果上面三步都没有删除，则向右子树递归
		if (this.right != null) {
			this.right.delNode(no);
		}
	}

	// 前序遍历的方法
	public void preOrder() {
		System.out.println(this);// 先输出父节点
		// 向左子树遍历
		if (this.left != null) {
			this.left.preOrder();
		}
		// 向右子树遍历
		if (this.right != null) {
			this.right.preOrder();
		}

	}

	// 中序遍历

	public void infixOrder() {
		// 左子树
		if (this.left != null) {
			this.left.infixOrder();
		}

		// 父节点
		System.out.println(this);

		// 右子树

		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	// 后序遍历
	public void postOrder() {
		// 左子树
		if (this.left != null) {
			this.left.postOrder();
		}
		// 右子树
		if (this.right != null) {
			this.right.postOrder();
		}
		// 父节点
		System.out.println(this);
	}

	//前序遍历查找
	public HeroNode preOrderSearch(int no) {
		if (this.no == no) {
			return this;
		}
		//判断当前节点的左节点是否为空，如果不为空则递归前序查找
		//如果左递归前序查找找到了，则返回
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
	//中序遍历查找
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
	//后序遍历查找
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
