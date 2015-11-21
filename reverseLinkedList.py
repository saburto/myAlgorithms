 
class Node(object):
 
   def __init__(self, data=None, next_node=None):
       self.data = data
       self.next = next_node




def Reverse(head):
    
    newNode = None
    next = None
    while head != None:
        
        newNode = Node(head.data, next)
        next = newNode 
        head = head.next
     
    return next

head = Node("A", Node("B", Node("C")))

head = Reverse(head)

while head != None:
	print head.data
	head = head.next
	