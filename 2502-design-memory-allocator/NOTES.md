import java.util.Arrays;
here's a modification to the allocate method that checks for available memory blocks in a cyclic manner if it reaches the end of the memory array:
class Allocator {
private int[] memoryArray;
​
public Allocator(int size) {
memoryArray = new int[size];
Arrays.fill(memoryArray, -1); // Initializing memory blocks as unavailable (-1 means available)
}
​
public int allocate(int blockSize, int mID) {
if (blockSize > memoryArray.length) {
return -1; // Indicate failure to allocate if requested block size exceeds available memory size
}
​
int count = 0;
int startIndex = 0;
int endIndex = 0;
​
for (int i = 0; i < memoryArray.length * 2; i++) {
int index = i % memoryArray.length;
if (memoryArray[index] == -1) {
count++;
} else {
count = 0;
startIndex = index + 1;
}
​
if (count == blockSize) {
endIndex = index;
break;
}
}
​
if (startIndex > endIndex) {
return -1; // Indicate failure to allocate contiguous memory blocks of required size
}
​
Arrays.fill(memoryArray, startIndex, Math.min(endIndex + 1, memoryArray.length), mID);
return startIndex; // Return the starting index of allocated memory
}
​
public int free(int mID) {
int count = 0;
​
for (int i = 0; i < memoryArray.length; i++) {
if (memoryArray[i] == mID) {
count++;
memoryArray[i] = -1; // Free the memory block
}
}
​
return count; // Return the number of freed memory blocks
}
}
​