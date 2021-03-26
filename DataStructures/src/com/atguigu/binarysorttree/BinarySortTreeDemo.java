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

//��������������
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
					
				
				if (targetNode.left != null) {//���Ҫɾ���Ľڵ������ӽڵ�
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