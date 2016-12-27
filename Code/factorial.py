def fact(n):
    def f(k):
        return k
    if n == 0 or n == 1:
        return 1
    else:
        return n* fact(n - 1)
