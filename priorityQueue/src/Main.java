public class Main {

    public static void main(String[] args) {
	PriorityQueue pq = new PriorityQueue();
        pq.push("1st",1);
        pq.push("2nd",2);
        pq.push("3rd",3);
        pq.push("1st",1);
        pq.print();
        pq.pop();
        System.out.println(pq.pop());
        pq.print();

        PriorityQueueUnsorted pqus = new PriorityQueueUnsorted();
        pqus.push("4th",4);
        pqus.push("2nd",2);
        pqus.push("3rd",3);
        pqus.push("1st",1);
        pqus.push("4th",4);
        pqus.push("3rd",3);
        pqus.push("4th",4);
        pqus.print();
        pqus.pop();
        pqus.print();
        System.out.println(pqus.pop());
        pqus.print();
        pqus.pop();
        pqus.print();

    }

}
