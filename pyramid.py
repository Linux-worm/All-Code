def pyramid(n):
	a, b, total = 0, n, 0
	while b:
		a, b = a + 1, b - 1
		total = total + a + b
	return total
print(pyramid(3))
