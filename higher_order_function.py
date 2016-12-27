def square(x):
	return x * x

def make_adder(n):
	def adder(k):
		return k + n
	return adder

def compose1(f, g):
	def h(x):
	    return f(g(x))
	return h

compose1(square, make_adder(2))(3)
				

