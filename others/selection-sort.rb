array = [5, 6, 7, 8, 3]

array.each_with_index {
	|val, index| 
	min = val
	for i in index + 1 ... array.size
		if array[i] < min
			min = array[i]
			array[i] = val			
		end
	end
	array[index] = min
}

puts array