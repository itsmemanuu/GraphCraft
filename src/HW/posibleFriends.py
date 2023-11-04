def posibleFriends(g, vi):
    posible = set()
    alreadyFriends = set()
    
    for e in g[vi]:
        v2 = e[0]
        alreadyFriends.add(v2)
        for e2 in g[v2]:
            v3 = e2[0]
            if v3 != vi:
                posible.add(v3)
    
    return posible - alreadyFriends

graph = [
    [(1, 1), (4, 1)],
    [(0, 1), (2, 1)],
    [(1, 1), (3, 1)],
    [(2, 1), (4, 1)],
    [(3, 1), (0, 1)]
]
# def alreadyFriends(g, vi, vf):
#     for e in g[vi]:
#         if e[0] == vf:
#             return True
#     return False

print(posibleFriends(graph, 0))



# fun posibleFriends(G(V, E, c): graph, vi: int):
# ret rec: set of int

# var {w, e}: E
# var posible: set of int
# var alreadyFriends: set of int

# for {v1, v2} ∊ E | v1 ∊ E ⋀ v2 ∊ E : v1 = vi ->
#   alreadyFriends := alreadyFriends ∪ {v2}
#   for {v3, v4} ∊ E | v3 ∊ E ⋀ v4 ∊ E : v3 = v2 ⋀ v4 != vi ->
#           posible := posible ∪ {v4}
#       fi
#   rof
# rof
# rec := posible - alreadyFriends
# ret rec
