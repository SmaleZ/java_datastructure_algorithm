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

		System.out.println("��û��ƽ�⴦��ǰ");
		System.out.println("���ĸ߶�=" + avlTree.getRoot().height());
		System.out.println("���ĸ߶�=" + avlTree.getRoot().leftHeight());
		System.out.println("���ĸ߶�=" + avlTree.getRoot().rightHeight());
	}

}

//����avl��
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

	// �������
	public void infixOrder() {
		if (root != null) {
			root.infixOrder();
		} else {
			System.out.println("����������Ϊ��");
		}
	}

	// ����Ҫɾ���Ľڵ�
	public Node search(int value) {
		if (root == null) {
			return null;
		} else {
			return root.search(value);
		}
	}

	// ����Ҫɾ���ڵ�ĸ��ڵ�
	public Node searchParent(int value) {
		if (root == null) {
			return null;
		} else {
			return root.searchParrent(value);
		}
	}

	// ɾ����������С
	/**
	 * 
	 * @param node
	 * @return ������nodeΪ���ڵ�Ķ�������������С�ڵ�ֵ
	 */
	public int delRightTreeMin(Node node) {
		Node target = node;
		// ѭ��������ڵ㣬�ͻ��ҵ���Сֵ
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
			// ȥ�ҵ�targetNode �ĸ��ڵ�
			Node parentNode = searchParent(value);

			// ���ɾ������Ҷ�ӽڵ�
			if (targetNode.left == null && targetNode.right == null) {
				// �ж�Ҫɾ���Ľڵ��Ǹ��ڵ����ڵ㻹���ҽڵ�
				if (parentNode.left != null && parentNode.left.value == value) {
					parentNode.left = null;
				} else if (parentNode.right != null && parentNode.right.value == value) {
					parentNode.right = null;
				}

			} else if (targetNode.left != null && targetNode.right != null) {// ɾ�������������Ľڵ�
				int minVal = delRightTreeMin(targetNode.right);
				targetNode.value = minVal;

			} else {// ɾ��ֻ��һ�������Ľڵ�

				if (targetNode.left != null) {// ���Ҫɾ���Ľڵ������ӽڵ�
					if (parentNode != null) {
						// ���targetnode ��parent �����ӽڵ�
						if (parentNode.left.value == value) {
							parentNode.left = targetNode.left;
						} else {// ���targetnode ��parent �����ӽڵ�
							parentNode.right = targetNode.left;
						}
					} else {
						root = targetNode.left;
					}
				} else {// ���Ҫɾ���Ľڵ������ӽڵ�
					if (parentNode != null) {
						if (parentNode.left.value == value) {// ���targetnode ��parent �����ӽڵ�
							parentNode.left = targetNode.right;
						} else {// ���targetnode ��parent �����ӽڵ�
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

//����node�ڵ�
class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		super();
		this.value = value;
	}

	// �����������ĸ߶�
	public int leftHeight() {
		if (left == null) {
			return 0;
		}
		return left.height();
	}

	// �����������ĸ߶�
	public int rightHeight() {
		if (right == null) {
			return 0;
		}
		return right.height();
	}

	// ���ص�ǰ�ڵ�ĸ߶ȣ��Դ˽ڵ�Ϊ���ڵ�����ĸ߶�
	public int height() {
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}

	// ����ת
	private void leftRotate() {
		Node newNode = new Node(value);
		// ���½ڵ����������ɵ�ǰ�ڵ��������
		newNode.left = left;
		// ���½ڵ����������ɵ�ǰ�ڵ���������������
		newNode.right = right.left;
		// �ѵ�ǰ�ڵ��ֵ���滻����������ֵ
		value = right.value;
		// �ѵ�ǰ�ڵ���������ɵ�ǰ�ڵ���������������
		right = right.right;
		// �ѵ�ǰ�ڵ������������µĽڵ�
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
	 * @return ����Ҫɾ���Ľڵ�
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
	 * @return ����Ҫ���ҵ�ֵ�ĸ��ڵ�
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

	// ��ӽڵ�ķ���
	// �ݹ����ӣ���Ҫ�������������
	public void add(Node node) {
		if (node == null) {
			return;
		}
		// �ж� Ҫ��ӵĽڵ�ֵ�뵱ǰ�������ڵ��ֵ�ù�ϵ
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

		// �������һ���ڵ������������ĸ߶ȱ��������ĸ߶ȴ�һ
		if (rightHeight() - leftHeight() > 1) {
			if (right != null && right.leftHeight() > right.rightHeight()) {//��Ҫ����˫��ת
				//�ȶԵ�ǰ�ڵ������������you��ת
				right.rightRotate();
				leftRotate();
			}else {
				leftRotate();
			}
			return ;
		}
		// �������һ���ڵ������������ĸ߶ȱ��������ĸ߶ȴ�һ
		if (leftHeight() - rightHeight() > 1) {
			
			if (left != null && left.rightHeight() > left.leftHeight()) {//��Ҫ����˫��ת
				// �ȶԵ�ǰ�ڵ����������������ת
				left.leftRotate();
				rightRotate();
			} else {
				rightRotate();
			}

		}

	}

	// �������
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