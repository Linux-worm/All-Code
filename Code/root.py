def findRoot(x, power, epsilon):
	low = 0
	high = 0
	ans = (high + low) / 2.0
	while abs(ans ** power - x) > epsilon:
		print(ans)
		if ans ** power < x:
			low = ans
		else:
			high = ans
		ans = (high + low ) / 2.0
	return ans

var = findRoot(25.0, 2, 0.001)
print(var)