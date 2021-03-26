package com.atguigu.binarysorttree;

public class BinarySortTreeDemo {

	public static void main(String[] args) {
		int[] arr = { 6, 7, 3, 10, 12, 5, 1, 9, 2 };
		BinarySortTree binarySortTree = new BinarySortTree();

		for (int i = 0; i < arr.length; i++) {
			binarySortTree.add(new Node(arr[i]));
		}
		// binarySortTree.delNode(2);
		binarySortTree.delNode(10);
		binarySortTree.infixOrder();
	}

}

//创建二叉排序树
class BinarySortTree {
	private Node root;

	// add
	public void add(Node node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	// 中序遍历
	public void infixOrder() {
		if (root != null) {
			root.infixOrder();
		} else {
			System.out.println("二叉排序树为空");
		}
	}

	// 查找要删除的节点
	public Node search(int value) {
		if (root == null) {
			return null;
		} else {
			return root.search(value);
		}
	}

	// 查找要删除节点的父节点
	public Node searchParent(int value) {
		if (root == null) {
			return null;
		} else {
			return root.searchParrent(value);
		}
	}

	// 删除左子树最小
	/**
	 * 
	 * @param node
	 * @return 返回以node为根节点的二叉排序树的最小节点值
	 */
	public int delRightTreeMin(Node node) {
		Node target = node;
		// 循环查找左节点，就会找到最小值
		while (target.left != null) {
			target = target.left;
		}
		delNode(target.value);
		return target.value;
	}

	public void delNode(int value) {
		if (root == null) {
			return;
		} else {
			Node targetNode = search(value);
			if (targetNode == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			// 去找到targetNode 的父节点
			Node parentNode = searchParent(value);

			// 如果删除的是叶子节点
			if (targetNode.left == null && targetNode.right == null) {
				// 判断要删除的节点是父节点的左节点还是右节点
				if (parentNode.left != null && parentNode.left.value == value) {
					parentNode.left = null;
				} else if (parentNode.right != null && parentNode.right.value == value) {
					parentNode.right = null;
				}
				
			} else if (targetNode.left != null && targetNode.right != null) {// 删除有俩棵子树的节点
				int minVal = delRightTreeMin(targetNode.right);
				targetNode.value = minVal;
				
			} else {// 删除只有一棵子树的节点
					
				
				if (targetNode.left != null) {//如果要删除的节点有左子节点
					if (parentNode != null) {
						// 如果targetnode 是parent 的左子节点
						if (parentNode.left.value == value) {
							parentNode.left = targetNode.left;
						} else {// 如果targetnode 是parent 的右子节点
							parentNode.right = targetNode.left;
						}
					} else {
						root = targetNode.left;
					}
				} else {// 如果要删除的节点有右子节点
					if (parentNode != null) {
						if (parentNode.left.value == value) {// 如果targetnode 是parent 的左子节点
							parentNode.left = targetNode.right;
						} else {// 如果targetnode 是parent 的右子节点
							parentNode.right = targetNode.right;
						}
					} else {
						root = targetNode.right;
					}
				}
			}

		}
	}
}

//创建node节点
class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		super();
		this.value = value;
	}

	/**
	 * @param value
	 * @return 返回要删除的节点
	 */
	public Node search(int value) {
		if (value == this.value) {
			return this;
		} else if (value < this.value) {
			if (this.left == null) {
				return null;
			}
			return this.left.search(value);
		} else {
			if (this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}

	/**
	 * 
	 * @param value
	 * @return 返回要查找的值的父节点
	 */
	public Node searchParrent(int value) {
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		} else {
			if (value < this.value && this.left != null) {
				return this.left.searchParrent(value);
			} else if (value >= this.value && this.right != null) {
				return this.right.searchParrent(value);
			} else {
				return null;
			}
		}
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	// 添加节点的方法
	// 递归的添加，需要满足二叉排序树
	public void add(Node node) {
		if (node == null) {
			return;
		}
		// 判断 要添加的节点值与当前子树根节点的值得关系
		if (node.value < this.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}

		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
		}

	}

	// 中序遍历
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}

		System.out.println(this);

		if (this.right != null) {
			this.right.infixOrder();
		}

	}
}