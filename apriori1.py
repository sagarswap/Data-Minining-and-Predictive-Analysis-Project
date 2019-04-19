items = ['q1', 'q2', 'q3', 'q4', 'q5']

dataset = [ ['q1', 'q2', 'q3', 'q4'],
            ['q1', 'q2', 'q3', 'q4', 'q5'],
            ['q2', 'q3', 'q4'],
            ['q2', 'q3', 'q5'],
            ['q1', 'q2', 'q4'],
            ['q1', 'q3', 'q4'],
            ['q2', 'q3', 'q4', 'q5'],
            ['q1', 'q3', 'q4', 'q5'],
            ['q3', 'q4', 'q5'],
            ['q1', 'q2', 'q3', 'q5']
            ]

def frequentItems(minSupport):
    freq = []
    count = [0]*len(items)
    for t in dataset:
        for i in t:
            count[i-1] = count[i-1] + 1

    for x, i in enumerate(count):
        if i >= minSupport:
            k = [x+1]
            freq.append(k)

    return freq

def isFrequent(s, minSupport):
    count = 0
    for i in dataset:
        x = all(elem in i for elem in s)
        if x:
            count = count + 1
    return count >= minSupport

def apriori(minSupport):
    L = []
    L.append(frequentItems(minSupport))
    p = 0
    for k in range(1, len(items)):
        C = []
        S = L[k-1]
        for i in range(len(S) - 1):
            for j in range(i+1, len(S)):
                l = S[i]
                h = S[j]
                if l[:p] == h[:p]:
                    if l[-1] < h[-1]:
                        tmp = l[:p]
                        tmp.append(l[-1])
                        tmp.append(h[-1])
                        C.append(tmp)
        p = p + 1
        T = [x for x in C if isFrequent(x, minSupport)]
        if not T:
            break
        L.append(T)
    return L
            
if __name__ == '__main__':
    L = apriori(4)
    print(L)
