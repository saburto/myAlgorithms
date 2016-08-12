# Enter your code here. Read input from STDIN. Print output to STDOUT

import sys
import cStringIO
import time
from sys import setrecursionlimit
millis = int(round(time.time() * 1000))



class Node(object):
    def __init__(self, data=None, left=None, right=None):
        self.d = data
        self.l = left
        self.r = right
        self.p = None
        self.firstData = None
        self.lastData = None
    def __str__(self):
        return "Data:{0}, left[{1}], right [{2}]".format(self.d, self.l, self.r)

class SplayTree(object):
    
    LEFT = "L"
    RIGHT = "R"
    def __init__(self):
        self.root = None
        self.count = 1

    def getNodeByPos(self, node, pos):
        if node.l != None:
            
            l = self.getNodeByPos(node.l, pos)
            self.count += 1
            if l != None:
                return l
            
        if self.count == pos:
            return node
        
        
        if node.r != None:
            self.count += 1
            r = self.getNodeByPos(node.r, pos)
            if r != None:
                return r
        return None
    
    def memberPos(self, pos):
        #print "Pos:" + str(pos)
        self.count = 1
        
        if self.root == None:
            return False
        
        current = self.getNodeByPos(self.root, pos)
        #print "Current data:" + str(current.d)
        
        
        if current != None:
            self.splay(current)
            return True
        else:
            return False
    
    def member(self, k):
        if self.root == None:
            return False
        current = self.root
        pred = None

        while current != None:
            if k == current.d:
                break
            pred = current
            if k < current.d:
                current = current.l
            else:
                current = current.r
        if current != None:
            self.splay(current)
            return True
        else:
            self.splay(pred)
            return False
    def addLeft(self,k):
        if self.root == None:
            self.root = Node(k)
            self.lastLeftAdded = self.root
            return
        newNode = Node(k)
        self.lastLeftAdded.l = newNode
        newNode.p = self.lastLeftAdded
        self.lastLeftAdded = newNode
    

    def singleRotate(self, node):
        if node.p.l == node:
            self.zigLeft(node)
        else:
            self.zigRight(node)
            
    def doubleRotate(self, node):
        if node.p.l == node and node.p.p.l == node.p:
            #print "zigzigleft"
            self.zigZigLeft(node)
            return
        if node.p.l == node and node.p.p.r == node.p:
            #print "zigzagleft"
            self.zigZagLeft(node)
            return
        if node.p.r == node and node.p.p.r == node.p:
            #print "zigzigRight"
            self.zigZigRight(node)
            return
        if node.p.r == node and node.p.p.l == node.p:
            #print "zigzagRight node:" + str(node.d)
            #self.printInOrder()
            self.zigZagRight(node)
            #print "After zig Zag"
            #self.printInOrder()
            return

    def splay(self, crt):
        father = crt.p
        while father != None:
            if father.p == None:
                self.singleRotate(crt)
            else:
                self.doubleRotate(crt)
            father = crt.p
        self.root = crt
    
    def zigLeft(self, node):
        p = node.p
        r = node.r
        node.r = p
        node.p = None
        if r != None:
            r.parent = p
        p.l = r
        p.p = node
    def zigRight(self, node):
        p = node.p
        l = node.l
        
        node.l = p
        node.p = None
        if l != None:
            l.p = p
        p.r = l
        p.p = node
        
    def zigZigLeft(self, node):
        p = node.p
        g = p.p
        b = node.r
        c = p.r
        ggp = g.p
        
        node.r = p
        p.p = node
        p.r = g
        g.p = p
        if b != None:
            b.p = p
        p.l = b
        if c != None:
            c.p = g
        g.l = c
        node.p = ggp
        if ggp != None:
            if ggp.l == g:
                ggp.l = node
            else:
                ggp.r = node
    def zigZigRight(self, node):
        p = node.p
        g = p.p
        b = node.l
        c = p.l
        ggp = g.p
        
        node.l = p
        p.p = node
        p.l = g
        g.p = p
        
        if b != None:
            b.p = p
        p.r = b
        if c != None:
            c.p = g
        g.r = c
        node.p = ggp
        if ggp != None:
            if ggp.l == g:
                ggp.l = node
            else:
                ggp.r = node
    def zigZagLeft(self, node):
        p = node.p
        g = p.p
        ggp = g.p
        
        a = node.l
        b = node.r
        
        node.l = g
        g.p = node
        node.r = p
        p.p = node
        
        if a != None:
            a.p = g
        g.r = a
        if b != None:
            b.p = p
        p.l = b
        node.p = ggp
        if ggp != None:
            if ggp.l == g:
                ggp.l = node
            else:
                ggp.r = node   
                
    def zigZagRight(self, node):
        #print "Node:" + str(node)
        p = node.p
        #print "Node Parent:" +str(p)
        
        
        g = p.p
        #print "Node grandparent:" + str(g)
        
        ggp = g.p
        #print "Node grandgrandparent:" + str(ggp)
       
        
        a = node.l
        b = node.r
        
        node.r = g
        g.p = node
        node.l = p
        p.p = node
        
        if a != None:
            a.p = p
        p.r = a
        if b != None:
            b.p = g
        g.l = b
        node.p = ggp
        if ggp != None:
            if ggp.l == g:
                ggp.l = node
            else:
                ggp.r = node

    def printInOrder(self):
        self.firstData = None
        self.lastData = None
        output = cStringIO.StringIO()
        self.printInOrderR(self.root, output)
        print abs(self.firstData - self.lastData)
        print output.getvalue()
        output.close()

            
    def printInOrderR(self, node, output):
        if (node != None):
            self.printInOrderR(node.l, output)
            
            if self.firstData == None:
                self.firstData = node.d
            self.lastData = node.d
            
            output.write(str(node.d) + " ")
            self.printInOrderR(node.r, output)
    def splitByPosEnd(self, pos):
        if self.root != None:
            self.memberPos(pos)
            
            res = self.root.l
            if res == None:
                return None
            res.p = None
            self.root.l = None
            
            resTree = SplayTree()
            resTree.root = res
            return resTree
        return None
   
    def joinFirst(self, leftTree):
        self.memberPos(1)
        lnode = self.root
        #while lnode.l != None:
        #    lnode = lnode.l
        lnode.l = leftTree.root
        leftTree.root.p = lnode
            
            
    
n, cn = map(int, raw_input().strip().split())

setrecursionlimit(n*10)

tree = SplayTree()
array = list(map(int, raw_input().strip().split()))
for x in range(len(array)-1, -1, -1):
#print "Inserting: " + str(x)
    tree.addLeft(array[x])
#print tree.root.d
#tree.printInOrder()    


for i in range(cn):
    c,s,e = map(int, raw_input().strip().split())
    #print "Command " + str(c)
    if c == 1:

        firstToInsert = tree.splitByPosEnd(s)
        
        #print "fist split"
        #firstToInsert.printInOrder()
        #tree.printInOrder()    
        
        lastToInsert = tree.splitByPosEnd((e-s)+2)
        
        if firstToInsert != None:
            tree.joinFirst(firstToInsert)
        if lastToInsert != None:
            tree.joinFirst(lastToInsert)
        
        #print " first "
        #tree.printInOrder()    
    if c == 2:
        
        first = tree.splitByPosEnd(s)
        
        last = tree.splitByPosEnd((e-s)+2)
       
        
        if first != None:
            tree.joinFirst(first)
            
        if last != None:
            last.joinFirst(tree)
            tree = last
        
        #print " SECOND after split "
        #tree.printInOrder()    

tree.printInOrder()
fin = int(round(time.time() * 1000))                
print "Tomo: " + str(fin - millis)