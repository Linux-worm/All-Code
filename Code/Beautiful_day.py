import sys
i, j, k = input().strip().split(' ')
i, j, k = [int(i), int(j), int(k)]
s = 0
for a in range(i, j + 1):
    b = int(str(a)[:: -1])
    if(abs(a - b) % k == 0):
        s += 1
print(s)    
    
