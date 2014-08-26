import sys


def matgen(r, c, filename):
    f = open(filename, "w")
    count = 0
    for i in range(0,r):
        row = ""
        for j in range(0, c):
            row += "%d\t" %(count)
            count += 1
        row = row.strip()
        row += "\n"
        f.write(row)


if len(sys.argv) != 4:
    print("Usage: %s <M> <P> <N>" %(sys.argv[0]))
    exit(-1)

m = int(sys.argv[1])
p = int(sys.argv[2])
n = int(sys.argv[3])
print("Generating matrix files of dimensions %d x %d and %d x %d" %(m, p, p, n)) 

matgen(m,p, "m1.txt")
matgen(p,n, "m2.txt")


