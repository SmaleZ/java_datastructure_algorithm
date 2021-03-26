package com.atguigu.avl;

public class AVLTreeDemo {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 6, 5, 7, 8 };
		int[] arr1 = { 10, 11, 7, 6, 8, 9 };
		AVLTree avlTree = new AVLTree();

		for (int i = 0; i < arr1.length; i++) {
			avlTree.add(new Node(arr1[i]));
		}

		avlTree.infixOrder();

		System.out.println("在没有平衡处理前");
		System.out.println("树的高度=" + avlTree.getRoot().height());
		System.out.println("树的高度=" + avlTree.getRoot().leftHeight());
		System.out.println("树的高度=" + avlTree.getRoot().rightHeight());
	}

}

//创建avl树
class AVLTree {
	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

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

				if (targetNode.left != null) {// 如果要删除的节点有左子节点
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

	// 返回左子树的高度
	public int leftHeight() {
		if (left == null) {
			return 0;
		}
		return left.height();
	}

	// 返回右子树的高度
	public int rightHeight() {
		if (right == null) {
			return 0;
		}
		return right.height();
	}

	// 返回当前节点的高度，以此节点为根节点的树的高度
	public int height() {
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}

	// 左旋转
	private void leftRotate() {
		Node newNode = new Node(value);
		// 把新节点的左子树设成当前节点的左子树
		newNode.left = left;
		// 把新节点的右子树设成当前节点右子树的左子树
		newNode.right = right.left;
		// 把当前节点的值，替换成右子树的值
		value = right.value;
		// 把当前节点右子树设成当前节点右子树的右子树
		right = right.right;
		// 把当前节点的左子树设成新的节点
		left = newNode;
	}

	private void rightRotate() {
		Node newNode = new Node(value);
		newNode.right = right;
		newNode.left = left.right;
		value = left.value;
		left = left.left;
		right = newNode;
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

		// 当添加完一个节点后，如果右子树的高度比左子树的高度大一
		if (rightHeight() - leftHeight() > 1) {
			if (right != null && right.leftHeight() > right.rightHeight()) {//需要进行双旋转
				//先对当前节点的右子树进行you旋转
				right.rightRotate();
				leftRotate();
			}else {
				leftRotate();
			}
			return ;
		}
		// 当添加完一个节点后，如果左子树的高度比右子树的高度大一
		if (leftHeight() - rightHeight() > 1) {
			
			if (left != null && left.rightHeight() > left.leftHeight()) {//需要进行双旋转
				// 先对当前节点的左子树进行左旋转
				left.leftRotate();
				rightRotate();
			} else {
				rightRotate();
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