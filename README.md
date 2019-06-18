# Adaptable and Flexible Priority Queue
Implement a adaptable and flexible priority queue ADT using min-heap and max-heap.
Specifications:
    1. must use a dynamically extendable array. No list, tree, vector, or heap 
    2. the PQ is adaptable meaning that any key or value of any entry of the PQ can be modified.
    3. the PQ is flexible meaning that the min-heap and max-heap can be exchanged mutually any time.
    4. no duplicated codes for constructing min-heap and max-heap
Access methods:
    removeTop(); insert(k,v); top(); remove(e); replacekey(e,k); replaceValue(e,v); isEmpty(); size();
    toggle(): transforms a min-heap to max-heap, or vice versa
    state(): returns the current state of the PQ
    
My solving steps:
    1. implements a priority queue
    2. implements a adaptable priority queue
    3. implements a adaptable and flexible PQ
        a. just modifies the comparison way for min-heap and max-heap, so there is no extra chage of other methods
