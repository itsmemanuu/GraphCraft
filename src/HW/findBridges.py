
def findBridges(g):
    bridges = 0
    i = 0
    while i < len(g):
        x = len(g[i])
        j = 0
        while j < x:
            e = g[i][j]
            e2 = (i, e[1])
            g[i].remove(e)
            g[e[0]].remove(e2)
            if not isConnected(g):
                bridges += 1
            g[i].insert(j, e)
            g[e[0]].insert(j, e2)
            j += 1
        i += 1
    return bridges//2
    
def isConnected(g):
    visited = [False] * len(g)
    q = []
    q.append(0)
    visited[0] = True
    
    while q:
        s = q.pop()
        for e in g[s]:
            if visited[e[0]] == False:
                q.append(e[0])
                visited[e[0]] = True
    
    if visited.count(False) > 0:
        return False
    return True

# Graph Structure:
# [
#  [(v,w), (v, w)],
#  [(v,w), (v, w), (v,w), (v, w)],
#  [(v,w), (v, w), (v,w)]
#  [(v,w), (v, w), (v,w), (v, w), (v,w), (v, w)]
# ]

graph = [
    [(1, 1)],
    [(0, 1), (2, 1)],
    [(1, 1), (3, 1)],
    [(2, 1)]
]

print(findBridges(graph))

# fun findBridges(G(V, E, c): graph)
# ret bridges: int

# var {w, e}: E
# var E': set of E
# bridges := 0
# for e ∊ E ->
#     E' := E - {e}
#     if isConnected(G(V, E', c)) = false -> bridges := bridges + 1 fi
# rof
# ret bridges


# fun isConnected(G(V, E, c): graph)
# ret c: bool

# var visited: array [0..|V|) of bool
# for x ∊ visited -> x := false rof

# var q: queue of int
# var s: int

# q.enqueue(0)
# visited[0] := true

# do q ≠ ∅ ->
#   s := q.dequeue()
#   for {v1, v2} ∊ E | v1 = s ->
#       if visited[v2] = false ->
#           q.enqueue(v2)
#           visited[v2] := true
#       fi
#   rof
# od

# c := true
# for x ∊ visited -> 
#   if x = false -> c:= false fi
# rof
# ret c






