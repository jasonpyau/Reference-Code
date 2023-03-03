#Random Python code to be referenced by me

import math
import random

words = ["sracecar", "apples", "two", "phone", "water", "tree", "object"]

for i, word in enumerate(words):
    if word == "sracecar":
        words[i] = word[::-1]
print(words)
if "racecars" not in words or "tree" not in words:
    print("racecars or tree is not in words")
elif "object" in words:
    print("racecars and tree and object is in words")
words.sort()
print("words in alphabetical order: "+str(words))
words.insert(1, "banana")
print("inserted 'banana' at index 1: "+str(words))

print("\n")

class Student:
    def __init__(self, name, age, school):
        self.name = name
        self.age = age
        self.school = school
        
    def __str__(self):
        return f"({self.name}, {self.age}, {self.school})"
        
s1 = Student("Jason", 18, "UCF")
s2 = Student("John", 35, "UCF")
print(s1)
print(s2)

print("\n")

values = []
a = 0
b = 0
for i in range(9):
    if i % 4 == 0 or i % 4 == 2:
        values.append((a*math.pi)/4)
        a += 1
    elif i % 4 == 1 or i % 4 == 3:
        values.append((b*math.pi)/6)
        b += 1
    if i % 4 == 0:
        b += 1

for val in values:
    sinVal = round(math.sin(val), 6)
    print("sin("+str(round(val,5))+") = "+str(sinVal))

print("\n")

for val in values:
    cosVal = round(math.cos(val), 6)
    print("cos("+str(round(val,5))+") = "+str(cosVal))
    
def fib(n):
    if n == 0:
        return 0
    elif n == 1 or n == 2:
        return 1
    else:
        return fib(n-1) + fib(n-2)

while (True):
    print("\nInput an integer to get the nth fibonacci number, or -1 to quit: ")
    userInput = int(input())
    if (userInput < 0):
        break
    else:
        print("The "+str(userInput)+"th fibonacci number is: "+str(fib(userInput)))

print("\n\nInput an int for size of array: ")
size = int(input())
print("Input an int for min value: ")
min = int(input())
print("Input an int for max value: ")
max = int(input())

randNums = [0] * size
for i in range(size):
    randNums[i] = random.randint(min, max)
print(randNums)

