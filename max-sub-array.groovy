
class Finder{

	def findMaxCrossingSubArray (List array, start, mid, end){
		def array1 = array.subList(start, mid);
		def array2 = array.subList(mid, end);
		print array1
		print " y "
		println array2
		println "Start:" + start + " Mid:" + mid + " End:" + end
		def leftSum = java.lang.Integer.MIN_VALUE
		def sum = 0
		def maxLeft = 0
		def i = mid-1; 
		while(i >= start){
			sum += array[i]
			if (sum > leftSum) {
				leftSum = sum
				maxLeft = i;
			}
			i--
		}

		
		def rightSum = java.lang.Integer.MIN_VALUE
		sum = 0
		def maxRight = 0
		def x = mid;
		while(x < end){
			sum += array[x]
			if(sum > rightSum){
				rightSum = sum
				maxRight = x
			}
			x++;
		}	
		def val = [maxLeft, maxRight + 1, leftSum + rightSum]
		println "Val" + val
		val
	}

	List findMaxSubArray (List array, int start, int end) {
		if (end - start == 1) { 
			return [start,end,array[start]]
		}else{
			def mid = (int)java.lang.Math.floor((start+end) / 2)
			def leftValues = findMaxSubArray(array, start, mid)
			def rightValues = findMaxSubArray(array, mid, end)

			def crossValues = findMaxCrossingSubArray(array, start, mid, end)

			if(leftValues[2] >= rightValues[2] && rightValues[2] >= crossValues[2]){
				return leftValues
			}

			if (rightValues[2] >= leftValues[2] && leftValues[2] >= crossValues[2]) {
				return rightValues
			}

			return crossValues

		}
	}

}

array = [13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7]
maxArray = new Finder().findMaxSubArray(array, 0, array.size())
println maxArray
i = maxArray[0]
while(i < maxArray[1]){
	print array[i++]
	print i == maxArray[1] ? "\n": ", "
}

