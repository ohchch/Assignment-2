class Node:
    def __init__(self, key):
        self.val = key
        self.left = None
        self.right = None

class BinarySearchTree:
    def __init__(self):
        self.root = None

    # --- Task A1: BST Core Operations ---

    def insert(self, key):
        self.root = self._insert_recursive(self.root, key)

    def _insert_recursive(self, root, key):
        if root is None:
            return Node(key)
        if key < root.val:
            root.left = self._insert_recursive(root.left, key)
        elif key > root.val:
            root.right = self._insert_recursive(root.right, key)
        return root

    def delete(self, key):
        self.root = self._delete_recursive(self.root, key)

    def _delete_recursive(self, root, key):
        if root is None:
            return root
        if key < root.val:
            root.left = self._delete_recursive(root.left, key)
        elif key > root.val:
            root.right = self._delete_recursive(root.right, key)
        else:
            # Node with only one child or no child
            if root.left is None:
                return root.right
            elif root.right is None:
                return root.left
            
            # Node with two children: Get the inorder successor (smallest in the right subtree)
            root.val = self._min_value(root.right)
            # Delete the inorder successor
            root.right = self._delete_recursive(root.right, root.val)
        return root

    def search(self, key):
        return self._search_recursive(self.root, key)

    def _search_recursive(self, root, key):
        if root is None:
            return False
        if root.val == key:
            return True
        if key < root.val:
            return self._search_recursive(root.left, key)
        return self._search_recursive(root.right, key)

    def _min_value(self, root):
        min_v = root.val
        while root.left:
            min_v = root.left.val
            root = root.left
        return min_v

    def find_min(self):
        if self.root is None:
            return None
        return self._min_value(self.root)

    def find_max(self):
        if self.root is None:
            return None
        current = self.root
        while current.right:
            current = current.right
        return current.val

    # --- Task A2: Tree Traversal ---

    def inorder_traversal(self):
        result = []
        self._inorder_recursive(self.root, result)
        return result

    def _inorder_recursive(self, root, result):
        if root:
            self._inorder_recursive(root.left, result)
            result.append(root.val)
            self._inorder_recursive(root.right, result)

    def preorder_traversal(self):
        result = []
        self._preorder_recursive(self.root, result)
        return result

    def _preorder_recursive(self, root, result):
        if root:
            result.append(root.val)
            self._preorder_recursive(root.left, result)
            self._preorder_recursive(root.right, result)

    def postorder_traversal(self):
        result = []
        self._postorder_recursive(self.root, result)
        return result

    def _postorder_recursive(self, root, result):
        if root:
            self._postorder_recursive(root.left, result)
            self._postorder_recursive(root.right, result)
            result.append(root.val)

    # --- Task A3: Tree Properties ---

    def height(self):
        return self._height_recursive(self.root)

    def _height_recursive(self, root):
        if root is None:
            return -1 # Matching Java implementation convention
        left_height = self._height_recursive(root.left)
        right_height = self._height_recursive(root.right)
        return max(left_height, right_height) + 1

    def node_count(self):
        return self._node_count_recursive(self.root)

    def _node_count_recursive(self, root):
        if root is None:
            return 0
        return 1 + self._node_count_recursive(root.left) + self._node_count_recursive(root.right)

    def leaf_count(self):
        return self._leaf_count_recursive(self.root)

    def _leaf_count_recursive(self, root):
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return 1
        return self._leaf_count_recursive(root.left) + self._leaf_count_recursive(root.right)
