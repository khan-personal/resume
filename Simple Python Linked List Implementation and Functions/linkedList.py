class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        
    # display linked list, O(n)
    def display(self):
        print("\ndiplaying the linked list...")
        node = self.head
        while node is not None:
            print(node.data)
            node = node.next
            
    # insert new node at head, O(1)
    def addAtHead(self, new):
        new_node = Node(new)
        new_node.next = self.head
        self.head = new_node
        
        print("new node added to head with data:", new)
        
    # insert node at tail, O(n) without a tail pointer
    def addAtTail(self, new):
        new_node = Node(new)
        
        node = self.head
        while node.next is not None:
            node = node.next
        node.next = new_node
        print("new node added to tail with data:", new)
        
    # insert after specific node, O(1)
    def addAfter(self, prev_node, new):
        if prev_node is None:
            print ("previous node is empty...")
        new_node = Node(new)
        new_node.next = prev_node.next
        prev_node.next = new_node
        print("new node inserted with data:", new)
        
    # delete node
    def deleteNode(self, key):
        # store head
        temp = self.head
        
        # if head node is node to be deleted
        if temp is not None:
            if temp.data == key:
                self.head = temp.next
                temp = None
                return
        
        # search for key, track prev node
        while temp is not None:
            if temp.data == key:
                break
            prev = temp
            temp = temp.next
        
        # if not found in list
        if temp is None:
            print("data not found in linked list, nothing deleted")
            return
        
        # unlink the node from linked list
        prev.next = temp.next
        print ("deleted data:", temp.data)
        
        temp = None    



# create linked list
link = LinkedList()

# create first node
element = Node("First Node")
# make prev node the head
link.head = element

# create second node
element2 = Node("Second Node")

link.head.next = element2


link.display()

link.addAtHead("New Head Node")

link.addAtTail("New Tail Node")

# insert after node pointed at in first parameter
link.addAfter(link.head, "Inserted After head")

link.display()

link.deleteNode("Second Node")

link.display()