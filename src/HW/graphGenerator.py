import random

with open("src/HW/testPrim.in", 'w') as f:
    with open("src/HW/testKruskal.in", 'w') as f2:
        f.write('100\n')
        f2.write('100\n')
        for i in range(100):
            n = random.randint(5, 20)
            adj_matrix = [['x' for j in range(n)] for i in range(n)]
            
            m = random.randint(n-1, n * (n - 1) // 2)
            
            for x in range(n):
                while True:
                    y = random.randint(0, n - 1)
                    w = random.randint(1, 100)
                    if adj_matrix[x][y] == 'x' and x != y:
                        adj_matrix[x][y] = w
                        adj_matrix[y][x] = w
                        break
            
            for j in range(n, m):
                while True:
                    x = random.randint(0, n - 1)
                    y = random.randint(0, n - 1)
                    w = random.randint(1, 100)
                    if adj_matrix[x][y] == 'x' and x != y:
                        adj_matrix[x][y] = w
                        adj_matrix[y][x] = w
                        break

            f.write(str(n) + '\n')
            f2.write(str(n) + '\n')
            for row in adj_matrix:
                f.write(' '.join(map(str, row)) + '\n')
            f.write('\n')
        
            for i in range(len(adj_matrix)):
                string = ""
                for j in range(len(adj_matrix[i])):
                    if adj_matrix[i][j] != 'x':
                        string += str(j) + ":" + str(adj_matrix[i][j]) + " "
                f2.write(string + '\n')
            f2.write('\n')
