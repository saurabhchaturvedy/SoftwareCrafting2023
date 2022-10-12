package main.java.LowLevelDesign.BrowserHistory;

class BrowserHistory_DLL {

    Node head; // most recently visited webpage
    Node tail; // webpage visited longest ago
    Node current; // webpage we are currently at

    public BrowserHistory_DLL(String homepage) {
        // when the first webpage is visited
        // that webpage becomes head, tail and current
        // becuase we have only one webpage as of now
        head = new Node(homepage);
        tail = head;
        current = head;
    }

    public void visit(String url) {
        Node newNode = new Node(url);

        // Requiremnets for visit(string url) method: Visits url from the current page. It clears up all the forward history.

        newNode.next = current; // the webpage to which current node currently points to goes one step back in history from the currently 
        // visited webpage which means the webpage which current node is pointing to becomes next node of the currently visited webpage
        current.prev = newNode; // the newly visited node becomes previous node of the webpage that is currently being pointed to by the current node

        head = newNode;  // newly visited webpage becomes head. This clears all forward history
        current = head; // newly visited webpage becomes current webpsge
    }

    public String forward(int steps) {
        // Requirements for forward(int steps) method: Move steps forward in history. 
        // If you can only forward x steps in the history and steps > x, 
        // you will forward only x steps. Return the current url after forwarding in history at most steps.

        Node node = current;
        // go towards head
        while (node.prev != null && steps > 0) {
            node = node.prev;
            steps--;
        }
        current = node;
        return node.url;
    }

    public String back(int steps) {
        // Requirements of back(int steps) method: Move steps back in history. 
        // If you can only return x steps in the history and steps > x, you will return only x steps. 
        // Return the current url after moving back in history at most steps.

        Node node = current;
        // go towards tail
        while (node.next != null && steps > 0) {
            node = node.next;
            steps--;
        }
        current = node;
        return node.url;
    }


    public void browserHistory(Node head) {

        Node thisNode = head;
        while (thisNode.next != null) {
            System.out.print(thisNode.url + " ->");
        }
    }

    class Node {
        public String url;
        public Node prev;
        public Node next;

        public Node(String url) {
            this.url = url;
        }
    }

    public static void main(String[] args) {

        BrowserHistory_DLL browserHistory = new BrowserHistory_DLL("google.com");
        browserHistory.visit("ibnlive.com");
        browserHistory.visit("cricinfo.com");
        browserHistory.visit("youtube.com");

        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.forward(1));

        browserHistory.browserHistory(browserHistory.head);
    }
}