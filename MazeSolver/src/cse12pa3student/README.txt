1_It is possible to call setPrevious() twice on the same square. An example is when solve method is using a queue work list to solve this maze:
#____
__#__
_##S_
__##_
F____

Because we are using a queue work list that adds to the end of the list, previous the square at row 1 and column 4 is added twice to the list before it is removed from the list and is marked as visited. Therefore the previous of this square is set to the square at row 2 column 4 the first time and row 1 column 3 the second time.
2_The statement is true because a queue work list adds to the end of the work list and removes and explores the first and closest neighbors of the start
square first. Hence, if the length of a path from a neighbor is less than another path from another neighbor, it will find that path.

3_A counter example is the same maze as in question 1 where if we use a stack work list, the solve() method visits 10 squares, but if a queue work list is used, 16 different squares are visited.