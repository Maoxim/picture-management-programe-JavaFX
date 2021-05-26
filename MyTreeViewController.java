package sample;

import java.util.Stack;

public class MyTreeViewController {
    private final Stack<String> fileStack = new Stack<>();
    private final Stack<String> fileStackTempt = new Stack<>();
    private final String path = "";

    public void pushFileStack(String fileTreeItem){
        fileStack.push(fileTreeItem);
    }

    public void initEnterFolder(String path) {
        //入栈以便于后续前进后退
        if (fileStack.isEmpty() || !fileStack.peek().equals(path)) {
            pushFileStack(path);
            fileStackTempt.clear();
        }
       // System.out.println(fileStack);
    }




}
