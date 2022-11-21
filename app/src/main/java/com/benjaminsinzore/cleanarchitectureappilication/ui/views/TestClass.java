package com.benjaminsinzore.cleanarchitectureappilication.ui.views;

public class TestClass {

    MyClass myClass = new MyClass();
    public String testMethod(String in){
        int getTotal = myClass.getTotal();
        return getTotal + " " + in;
    }

}

class MyClass{

    int one = 20;
    int two = 20;

    public int getTotal(){
        int res;
        res = one + two;
        return res;
    }
}
