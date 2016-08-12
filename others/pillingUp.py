# Enter your code here. Read input from STDIN. Print output to STDOUT
t = int(raw_input())
r = []
for i in range(t):
    n = int(raw_input())
    values = list(map(int, raw_input().strip().split(" ")))
    pile = [9223372036854775807]
    
    x = 0
    y = n-1
    ans = True
    while x != y and ans:
        if values[x] >= values[y]:
            p = pile.pop()
            if p >= values[x]:
                pile.append(p)
                pile.append(values[x])
            else:
                ans = False
                
            x+=1
        else:
            p = pile.pop()
            if p >= values[y]:
                pile.append(p)
                pile.append(values[y])
            else:
                ans = False
            y-=1    
    print "Yes" if ans else "No"     