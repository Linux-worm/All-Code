file = open('Shakespeare.txt')
text = file.read().split()
words = set(text)
{w for w in words if w == w[::-1] and len(w) > 4}
{w for w in words if w[::-1] in words and len(w) == 4}