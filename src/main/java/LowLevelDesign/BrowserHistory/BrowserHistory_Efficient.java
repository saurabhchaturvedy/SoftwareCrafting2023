package main.java.LowLevelDesign.BrowserHistory;

import java.util.ArrayList;
import java.util.List;

class BrowserHistory_Efficient {

    List<String> visitedWebpages;
    int currentIndex;
    int currentHistorySize; // to keep track of where the forward current history end

    public BrowserHistory_Efficient(String homepage) {
        visitedWebpages = new ArrayList<String>();
        visitedWebpages.add(homepage);
        currentIndex = 0;
        currentHistorySize = 1;
    }

    public void visit(String url) {
        currentIndex++;
        if (currentIndex <= visitedWebpages.size() - 1) {
            visitedWebpages.set(currentIndex, url); // replace. This optimizes time complexity rather than doing add() operation since add(index, value) is O(n) but set() is O(1)
        } else {
            visitedWebpages.add(currentIndex, url); // O(1)
        }
        currentHistorySize = currentIndex + 1;
    }

    public String back(int steps) {
        currentIndex = Math.max(0, currentIndex - steps);
        return visitedWebpages.get(currentIndex);
    }

    public String forward(int steps) {
        currentIndex = Math.min(currentHistorySize - 1, currentIndex + steps);
        return visitedWebpages.get(currentIndex);
    }
}