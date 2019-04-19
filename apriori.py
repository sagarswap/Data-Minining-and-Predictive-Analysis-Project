# -*- coding: utf-8 -*-
"""
Created on Tue Feb  5 19:34:20 2019

@author: Swapnil
"""

def main():
    i=0
    min_sup=0
    t=0
    n=0
    l=[]
    f=open("D:\Programming\Python\Programs\\aprio_question.txt", "r")
    fl =f.readlines()
    for x in fl:
        print(x)
        if i==0 :
            min_sup=int(x)
        elif i==1 :
            t=int(x)
        elif i==2 :
            n=int(x)
        else:
            l.append(list(x))
        i=i+1;
    i=i-2
    print(l)
    ans=[]
    for x in range(n):
        ans.append(x+1)
    chkcount(ans, min_sup, l)
            

def chkcount(ans, min_sup, l):
    ans=[]
    for x in l:
        cnt=iterate(x, l)
        if cnt>(min_sup-1):
            ans.append(x)
    return ans
if __name__== "__main__":
  main()