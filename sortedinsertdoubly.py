class Node(object):
 
   def __init__(self, data=None, next_node=None, prev_node = None):
       self.data = data
       self.next = next_node
       self.prev = prev_node

def SortedInsert(head, data):
    
    if head == None:
        return Node(data)
    
    if data <= head.data :
        return Node(data, head)
    
    node = head
    prev = head
    while node != None:
        if data <= node.data:
            newNode = Node(data, node, node.prev)
            node.prev.next = newNode
            node.prev = newNode
            return head
        prev = node
        node = node.next

    prev.next = Node(data, None, prev)
  
    return head


node1 = Node(1)
node2 = Node(3)
node3 = Node(3)
node4 = Node(4)
node5 = Node(6)
node6 = Node(7)

node1.next = node2

node2.next = node3
node2.prev = node1

node3.next = node4
node3.prev = node2

node4.next = node5
node4.prev = node3

node5.next = node6
node5.prev = node4

node6.prev = node5



#head = SortedInsert(node1, 8)
#head = SortedInsert(node1, 5)
head = SortedInsert(node1, 10)

while head != None:
  print head.data
  head = head.next