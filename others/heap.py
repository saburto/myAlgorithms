class Heap(object):

	def __init__(self, array):
		self.array = array
		self.index = 0
		self.size = len(array)

	def parent(self, index):
		if self.isRoot(index):
			return None
		return self.array[index/2]

	def left(self, index):
		return self.array[index*2]

	def right(self, index):
		return self.array[index*2+1]

	def isRoot(self, index):
		return index == 0

	def __iter__(self):
		return self

	def next(self): # Python 3: def __next__(self)
		if self.index == len(self.array):
			raise StopIteration
		else:
			self.index += 1
			return self.array[self.index - 1]
	def printInOrder(self, index = 1):
		if index <= len(self.array):
			print self.array[index-1]
			self.printInOrder(self.leftIndex(index))
			self.printInOrder(self.rightIndex(index))
	def leftIndex(self, index):
		return index * 2
	def rightIndex(self, index):
		return index*2+1

	def maxHeapify(self, index):
		left = self.leftIndex(index)
		right = self.rightIndex(index)
		largest = 0

		if left <= self.size and self.array[left-1] > self.array[index-1]:
			largest = left
		else:
			largest = index

		if right <= self.size and self.array[right-1] > self.array[largest-1]:
			largest = right

		if largest != index:
			temp = self.array[index-1]
			self.array[index-1] = self.array[largest-1]
			self.array[largest-1] = temp
			self.maxHeapify(largest)

	def toMaxHeap(self):
		for x in xrange(len(self.array)/2, 0, -1):
			self.maxHeapify(x)

	def heapsort(self):
		self.toMaxHeap()
		for x in xrange(len(self.array), 1, -1):

			temp = self.array[0];
			self.array[0] = self.array[x-1]
			self.array[x-1] = temp

			self.size -= 1
			self.maxHeapify(1)




head = Heap([1,4,5,6,9]);



print head.parent(0)
print head.left(0)
print head.right(0)

print "In Order"
head.printInOrder()

print "In Order Maxify"
# head.toMaxHeap();
head.heapsort()

print "In Order Maxify"
head.printInOrder()


print "Heap"
for x in head:
	print x

		
		