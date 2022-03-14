package lab1_1;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public  class SimpleStack<T>{

    private int limit = -1;
    private ArrayList<T> stack;

    public SimpleStack() {this.stack = new ArrayList<T>();}

    public SimpleStack(int limit) {
        this.stack = new ArrayList<T>();
        this.limit = limit;
    }

    public boolean isEmpty(){return this.stack.isEmpty();}

    public int size(){return this.stack.size();}

    public void push(T t){
        if(limit != -1 && this.stack.size()+1 > limit){
            throw new IllegalStateException();
        }
        else{
            this.stack.add(t);}
        }
        

    public T pop(){
        if(this.stack.isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return this.stack.remove(this.stack.size()-1);
        }
    }

    public T peek(){
        if(this.stack.isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return this.stack.get(this.stack.size()-1);
        }
    }
}
