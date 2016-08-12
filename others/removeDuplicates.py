class Node(object):
 
   def __init__(self, data=None, next_node=None):
       self.data = data
       self.next = next_node



def RemoveDuplicates(head):
    prev = head
    node = head.next
    while node != None:
        if prev.data == node.data:
            prev.next = node.next
        else:
        	prev = node
       	node = node.next
    return head


head = Node("1", Node("1", Node("1", Node("1", Node("1")))))
#head = Node("1", Node("3", Node("3", Node("4", Node("6")))))

head = RemoveDuplicates(head)

while head != None:
	print head.data
	head = head.next
	