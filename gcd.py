def trace(f):
    def traced(m, n):
        print('Called on', m, 'and', n)
        return f(m, n)
    return traced


@trace
def gcd(m, n):
    """Return the largest k that evenly divides 
    both m and n

    >>> gcd(12, 8)
    4
    >>> gcd(16, 12)
    4
    >>> gcd(2, 16)
    2
    >>> gcd(24, 42)
    6
    >>> gcd(5, 5)
    5
    """
    if m % n == 0:
        return n
    elif m < n:
        return gcd(n, m)
    else:
        return gcd(m - n, n)
