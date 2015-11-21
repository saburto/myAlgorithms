
def printArrayKey(array, key, markStart, markEnd):
	printString = ''
	for i, x in enumerate(array):
		if i == 0:
			printString += "["
		if x == key:
			printString += " %s%s%s" % (markStart, x, markEnd)
		else:
			printString += " %s" % x
		if i != len(array) -1:
			printString += ","
		else:
			printString += "]"
	print printString

values = [4, 6, 7, 8, 9, 3]
print values

for j in range(1, len(values)):
	key = values[j]
	printArrayKey(values, key, "[", "]")
	i = j - 1
	print "Comparing: %s > %s" % (values[i] , key)
	while i >= 0 and values[i] > key:
		print "Moving: %s -> %s" % (values[i], values[i + 1])

		values[i + 1] = values[i]
		i = i - 1
		printArrayKey(values, values[i+1], "<", ">")
		print "Comparing: %s > %s" % (values[i] , key)
	values[i + 1] = key
	print ""
print values
	



