package main.java.LowLevelDesign.ThreadPrintEvenOdd;

public class Printer implements Runnable {

    int step=0;
    State state;
    int currentValue=0;
    PrinterType currentPrinter;
    PrinterType nextPrinter;
    int maxValue=0;

    public Printer(int step,int startValue, State state, PrinterType currentPrinter, PrinterType nextPrinter, int maxValue) {
        this.step = step;
        this.state = state;
        this.currentValue = startValue;
        this.currentPrinter = currentPrinter;
        this.nextPrinter = nextPrinter;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {


        while (currentValue<=maxValue)
        {
            synchronized (state)
            {
                while (this.currentPrinter!=state.getNextPrinter())
                {
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(this.currentPrinter.toString()+" : "+currentValue);
                currentValue = currentValue+step;
                state.setNextPrinter(nextPrinter);
                state.notifyAll();
            }
        }

    }
}
