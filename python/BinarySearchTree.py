class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.val = key

class BinarySearchTree:
    def __init__(self):
        self.root = None

    def insert(self, key):
        if self.root is None:
            self.root = Node(key)
        else:
            self._insert_recursively(self.root, key)

    def _insert_recursively(self, root, key):
        if key < root.val:
            if root.left is None:
                root.left = Node(key)
            else:
                self._insert_recursively(root.left, key)
        else:
            if root.right is None:
                root.right = Node(key)
            else:
                self._insert_recursively(root.right, key)

    def delete(self, key):
        self.root = self._delete_recursively(self.root, key)

    def _delete_recursively(self, root, key):
        if root is None:
            return root
        if key < root.val:
            root.left = self._delete_recursively(root.left, key)
        elif key > root.val:
            root.right = self._delete_recursively(root.right, key)
        else:
            if root.left is None:
                return root.right
            elif root.right is None:
                return root.left
            temp = self._min_value_node(root.right)
            root.val = temp.val
            root.right = self._delete_recursively(root.right, temp.val)
        return root

    def _min_value_node(self, node):
        current = node
        while current.left:
            current = current.left
        return current

    def search(self, key):
        return self._search_recursively(self.root, key)

    def _search_recursively(self, root, key):
        if root is None or root.val == key:
            return root
        if key < root.val:
            return self._search_recursively(root.left, key)
        return self._search_recursively(root.right, key)

    def find_min(self):
        return self._min_value_node(self.root).val if self.root else None

    def find_max(self):
        return self._max_value_node(self.root).val if self.root else None

    def _max_value_node(self, node):
        current = node
        while current.right:
            current = current.right
        return current

    def inorder_traversal(self):
        return self._inorder_recursively(self.root)

    def _inorder_recursively(self, root):
        return (self._inorder_recursively(root.left) if root.left else []) + [root.val] + (self._inorder_recursively(root.right) if root.right else []) if root else []

    def preorder_traversal(self):
        return self._preorder_recursively(self.root)

    def _preorder_recursively(self, root):
        return [root.val] + (self._preorder_recursively(root.left) if root.left else []) + (self._preorder_recursively(root.right) if root.right else []) if root else []

    def postorder_traversal(self):
        return self._postorder_recursively(self.root)

    def _postorder_recursively(self, root):
        return (self._postorder_recursively(root.left) if root.left else []) + (self._postorder_recursively(root.right) if root.right else []) + [root.val] if root else []

    def height(self):
        return self._height_recursively(self.root)

    def _height_recursively(self, root):
        if root is None:
            return 0
        return 1 + max(self._height_recursively(root.left), self._height_recursively(root.right))

    def node_count(self):
        return self._node_count_recursively(self.root)

    def _node_count_recursively(self, root):
        if root is None:
            return 0
        return 1 + self._node_count_recursively(root.left) + self._node_count_recursively(root.right)

    def leaf_count(self):
        return self._leaf_count_recursively(self.root)

    def _leaf_count_recursively(self, root):
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return 1
        return self._leaf_count_recursively(root.left) + self._leaf_count_recursively(root.right)
