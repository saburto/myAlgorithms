class Node(object):
 
   def __init__(self, data=None, next_node=None):
       self.data = data
       self.next = next_node


	
def GetNode(head, position):
    dic = []
    count = 0
    while head != None:
        
        dic.append(head.data)
        count += 1
        head = head.next
    print dic
    print count - position
    return dic[(count - position)-1]


print GetNode(Node("A", Node("B", Node("C", Node("D")))), 0)		
  