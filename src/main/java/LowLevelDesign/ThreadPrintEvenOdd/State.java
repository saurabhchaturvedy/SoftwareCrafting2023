package main.java.LowLevelDesign.ThreadPrintEvenOdd;

public class State {

    PrinterType nextPrinter;

    State(PrinterType nextPrinter) {
        this.nextPrinter = nextPrinter;
    }

    public PrinterType getNextPrinter() {
        return nextPrinter;
    }

    public void setNextPrinter(PrinterType nextPrinter) {
        this.nextPrinter = nextPrinter;
    }
}
