class Node(object):
 
   def __init__(self, data=None, next_node=None, prev_node = None):
       self.data = data
       self.next = next_node
       self.prev = prev_node

def Reverse(head):
    
    newHead = None
    while head != None:
        next = head.next
        prev = head.prev    
        head.prev = next
        head.next = prev
        newHead = head
        head = next
  
    return newHead


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


head = Reverse(node1)

while head != None:
  print head.data
  head = head.next