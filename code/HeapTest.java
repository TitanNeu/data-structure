package indi.datastructure;

import java.util.Random;

public class HeapTest {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        Random random = new Random();
        while(!heap.isFull()){
            heap.insert(random.nextInt(100));
        }
        heap.buildMaxHeap();

        while(!heap.isEmpty()){
            System.out.println(heap.delete());
        }

    }


}

//普通堆
class Heap{
    //节点值
    private int[] data;
    //目前堆容量
    private int size;
    //堆总容量
    private int capacity;


    public Heap(int size){
        data = new int[size+1];
        this.size = 0;
        this.capacity = size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == capacity;
    }

    public boolean insert(int elem){
        if(isFull())
            return false;
        data[++size] = elem;

        return true;
    }

    //调整最大堆
    public void buildMaxHeap(){
        for(int i = size/2; i >= 1; i--){
            buildMaxHeapCore(i);
        }
    }

    public void buildMaxHeapCore(int p){
        int root = data[p];
        int parent = 0, child = 0;
        for(parent = p; parent*2 <= size; parent = child){
            child = parent*2;
            if(child != size && data[child] < data[child+1]){
                ++child;
            }
            if(root > data[child]){
                break;
            } else {
                data[parent] = data[child];
            }
        }
        data[parent] = root;
    }

    public int delete() {
        if(isEmpty()){
            try {
                throw new Exception("堆已经空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int root = data[1];
        int tail = data[size--];
        int parent = 1, child = 0;

        for(parent = 1; parent*2 <= size; parent = child){
            child = parent*2;
            if(child != size && data[child] < data[child+1]){
                ++child;
            }
            if(tail > data[child]){
                break;
            } else {
                data[parent] = data[child];
            }
        }

        data[parent] = tail;

        return root;
    }

    public int[] getData(){
        return data;
    }
}


class MaxHeap{
    //节点值
    private int[] data;
    //目前堆容量
    private int size;
    //堆总容量
    private int capacity;

    public MaxHeap(int size){
        //节点从索引1开始，到size结束
        data = new int[size+1];
        this.size = 0;
        this.capacity = size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == capacity;
    }

    public boolean insert(int elem){
        if(isFull()){
            return false;
        }

        int i = ++size;

        //从下往上过滤
        for(; i != 1 && data[i/2] < elem; i /= 2){
            data[i] = data[i/2];
        }

        data[i] = elem;

        return true;
    }

    public int delete() {
        if(isEmpty()){
            try {
                throw new Exception("堆已经空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int root = data[1];
        int tail = data[size--];
        int parent = 1, child = 0;

        for(parent = 1; parent*2 <= size; parent = child){
            child = parent*2;
            if(child != size && data[child] < data[child+1]){
                ++child;
            }
            if(tail > data[child]){
                break;
            } else {
                data[parent] = data[child];
            }
        }

        data[parent] = tail;

        return root;
    }





}
