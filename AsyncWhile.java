package sample;

import javafx.application.Platform;

import java.util.function.IntPredicate;

public class AsyncWhile {

    private final IntPredicate hook;
    private int schedCount = 0;
    private boolean terminated = false;
    private int callCount = 0;
    private static final int schedN = 1;

    public AsyncWhile(IntPredicate hook) {
        this.hook = hook;
        schedule();
    }

    public void kill(){
        terminated = true;
    }

    private void schedule(){
        while(schedCount < schedN){
            Platform.runLater(this::poll);
            schedCount++;
        }
    }

    private void poll(){
        schedCount--;
        if(!terminated){
            terminated = !hook.test(callCount++);
            if(!terminated){
                schedule();
            }
        }
    }
}