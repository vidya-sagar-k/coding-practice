// Implement a Stack that can store any object that does the following:

// push() Adds an element to the stack.
// pop() Removes the last element of the stack.
// top() Returns the top most element of the stack.
// empty() Returns whether the stack is empty or not.


// MyStack<Integer> s1 = new MyStack <>(3);
// MyStack<String> s1 = new MyStack <>(3);
// MyStack<Long> s1 = new MyStack <>(3);
// ===
package com.example.sagar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SagarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SagarApplication.class, args);
        MyStack<Integer> s1 = new MyStack <>(3);
        MyStack<String> s2 = new MyStack <>(3);
        MyStack<Long> s3 = new MyStack <>(3);


        s1.push(1);
        s1.push(3);
        s1.push(2);
        System.out.println("s1 top :  " + s1.top());
        s1.push(0);
        System.out.println("s1 top :  " + s1.top());
        System.out.println("s1 empty :  " + s1.isEmpty());

        s1.pop();
        s1.pop();
        System.out.println("s1 empty :  " + s1.isEmpty());
        System.out.println("s1 top :  " + s1.top());

        s1.pop();
        System.out.println("s1 empty :  " + s1.isEmpty());

    }

}


//=====

package com.example.sagar;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
  private int capacity;
  private List<T> itemList;

  public MyStack(int capacity) {
    this.capacity = capacity;
    this.itemList = new ArrayList<>();
  }

  public boolean push(T item) {
    if (itemList.size() ==  capacity) {
      return false;
    }

    itemList.add(item);
    return true;

  }

  public T pop() {
    if (itemList.isEmpty()) return null;
    int lastIndex = itemList.size()-1;
    T item = itemList.get(lastIndex);
    itemList.remove(lastIndex);

    return item;
  }

  public T top() {
    if (itemList.isEmpty()) return null;

    int lastIndex = itemList.size()-1;
    return itemList.get(lastIndex);
  }

  public boolean isEmpty() {
    return itemList.isEmpty();
  }

}
