
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args)
    {
        //Generate 5 start-end pairs
        int[] starts = generateStart(5,5000);
        int[] ends = generateEnd(5,5000);
        System.out.println("Starts and Ends pairs");
        System.out.println("starts" + Arrays.toString(starts));
        System.out.println("ends" + Arrays.toString(ends));
        //Generate 5 G1 graphs
        LinkedList<Graph> graphListG1 = new LinkedList<>();
        generateG1(graphListG1);
        //Generate 5 G2 graphs
        LinkedList<Graph> graphListG2 = new LinkedList<>();
        generateG2(graphListG2);
        // 4 list to store running time for each graph, algorithm and s-t pairs
        LinkedList<Long> timesOriginalDijG1 = new LinkedList<>();
        LinkedList<Long> timesOriginalDijG2 = new LinkedList<>();
        LinkedList<Long> timesMaxHeapDijG1 = new LinkedList<>();
        LinkedList<Long> timesMaxHeapDijG2 = new LinkedList<>();

        for (int i=0;i<5;i++){
            int s = starts[i];
            int t = ends[i];
            for (Graph graph : graphListG1){
                System.out.println("-----------Graph1 separate lines ------------------");
                DijOriginMaxBand dijOriginMaxBand = new DijOriginMaxBand(5000,s,t,graph);
                DijMaxHeapMaxBW dijMaxHeapMaxBW = new DijMaxHeapMaxBW(5000,s,t,graph);
                long startTime = System.nanoTime();
                dijOriginMaxBand.maxBandWidth();
                long finishTime = System.nanoTime();
                long durationInNano = finishTime - startTime;
                timesOriginalDijG1.add(durationInNano);

                startTime = System.nanoTime();
                dijMaxHeapMaxBW.maxBandWidth();
                finishTime = System.nanoTime();
                long durationInNanoHeap = finishTime - startTime;
                timesMaxHeapDijG1.add(durationInNanoHeap);

                Stack<Integer> pathHeap = dijMaxHeapMaxBW.getPath();
                Stack<Integer> path = dijOriginMaxBand.getPath();
                int j = 0;
                System.out.println();
                System.out.println("Dij without Heap G1:");
                while (path.size() >0){
                    j++;
                    System.out.print(path.pop() + "-->");
                    if(j%25 ==0){
                        System.out.println();
                    }
                }
                j = 0;
                System.out.println();
                System.out.println("Dij with Heap G1:");
                while (pathHeap.size() >0){
                    j++;
                    System.out.print(pathHeap.pop() + "-->");
                    if(j%25 ==0){
                        System.out.println();
                    }
                }

            }

            for (Graph graph : graphListG2){
                System.out.println("-----------Graph2 separate lines ------------------");
                DijOriginMaxBand dijOriginMaxBand = new DijOriginMaxBand(5000,s,t,graph);
                DijMaxHeapMaxBW dijMaxHeapMaxBW = new DijMaxHeapMaxBW(5000,s,t,graph);
                long startTime = System.nanoTime();
                dijOriginMaxBand.maxBandWidth();
                long finishTime = System.nanoTime();
                long durationInNano = finishTime - startTime;
                timesOriginalDijG2.add(durationInNano);

                startTime = System.nanoTime();
                dijMaxHeapMaxBW.maxBandWidth();
                finishTime = System.nanoTime();
                long durationInNanoHeap = finishTime - startTime;
                timesMaxHeapDijG2.add(durationInNanoHeap);

                Stack<Integer> pathHeap = dijMaxHeapMaxBW.getPath();
                Stack<Integer> path = dijOriginMaxBand.getPath();
                int j = 0;
                System.out.println();
                System.out.println("Dij without Heap G2:");
                while (path.size() >0){
                    j++;
                    System.out.print(path.pop() + "-->");
                    if(j%25 ==0){
                        System.out.println();
                    }
                }
                j = 0;
                System.out.println();
                System.out.println("Dij with Heap G2:");
                while (pathHeap.size() >0){
                    j++;
                    System.out.print(pathHeap.pop() + "-->");
                    if(j%25 ==0){
                        System.out.println();
                    }
                }
            }

        }
        System.out.println();
        System.out.println("Without heap Dij for G1:");
        System.out.println(timesOriginalDijG1.toString());
        System.out.println("With heap Dij for G1:");
        System.out.println(timesMaxHeapDijG1.toString());
        System.out.println("Without heap Dij for G2:");
        System.out.println(timesOriginalDijG2.toString());
        System.out.println("With heap Dij for G2:");
        System.out.println(timesMaxHeapDijG2.toString());


    }

    public static void generateG1(LinkedList<Graph> graphListG){
        for (int i = 0; i < 5; i++) {
            graphListG.add(new Graph(5000));
        }
        GraphGenerator graphGeneratorG = new GraphGenerator(20,graphListG);
        graphGeneratorG.connectByCircle();
        graphGeneratorG.generateG1(6);
    }

    public static void generateG2(LinkedList<Graph> graphListG){
        for (int i = 0; i < 5; i++) {
            graphListG.add(new Graph(5000));
        }
        GraphGenerator graphGeneratorG = new GraphGenerator(20,graphListG);
        graphGeneratorG.connectByCircle();
        graphGeneratorG.generateG2(1000,10,2500000);
    }

    public static int[] generateStart(int size, int vertexBound){
        Random rand = new Random();
        int[] starts = new int[size];
        for (int i =0; i<size;i++){
            starts[i] = rand.nextInt(vertexBound);
        }
        return starts;
    }

    public static int[] generateEnd(int size, int vertexBound){
        Random rand = new Random();
        int[] ends = new int[size];
        for (int i =0; i<size;i++){
            ends[i] = rand.nextInt(vertexBound);
        }
        return ends;
    }

}
