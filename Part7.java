//Mergesort:
//        [9, 0, 8, 3, 7, 1, 4]
//        1:    [9, 0, 8] – sort left half
//2:        [9, 0] – sort left half
//3:            [9] – sort left half
//3:            [0] – sort right half
//3:            [0, 9] – merged and sorted
//2:        [8] – sort right half
//2:        [0, 8, 9] – merged and sorted
//1:    [3, 7, 1, 4] – sort right half
//2:        [3, 7] – sort left half
//3:            [3] – sort left half
//3:            [7] – sort right half
//3:            [3, 7] – merged and sorted
//2:        [1, 4] – sort right half
//3:            [1] – sort left half
//3:            [4] – sort right half
//3:            [1, 4] – merged and sorted
//2:        [1, 3, 4, 7] – merged and sorted
//1:    [0, 1, 3, 4, 7, 8, 9] – merged and sorted