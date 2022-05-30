import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DijOriginMaxBandTest {


    @Test
    void testG1(){
        LinkedList<Graph> graphListG1 = new LinkedList<Graph>();

        for (int i = 0; i < 5; i++) {
            graphListG1.add(new Graph(10));

        }

        GraphGenerator graphGeneratorG1 = new GraphGenerator(20,graphListG1);
        graphGeneratorG1.connectByCircle();
        DijOriginMaxBand dijOriginMaxBand = new DijOriginMaxBand(10,2,8,graphListG1.get(0));
        dijOriginMaxBand.maxBandWidth();
        Stack<Integer> path = dijOriginMaxBand.getPath();

        while (path.size() >0){
            System.out.print(path.pop() + "-->");
        }

        System.out.println("status" + Arrays.toString(dijOriginMaxBand.getStatus()));
        System.out.println("Bws" + Arrays.toString(dijOriginMaxBand.getBw()));
        System.out.println("Dads" + Arrays.toString(dijOriginMaxBand.getDad()));

        System.out.println("Just a line break");
        graphListG1.get(0).printG();
    }
    @Test
    void testG15000(){
        LinkedList<Graph> graphListG1 = new LinkedList<Graph>();

        for (int i = 0; i < 2; i++) {
            graphListG1.add(new Graph(5000));

        }

        GraphGenerator graphGeneratorG1 = new GraphGenerator(20,graphListG1);
        graphGeneratorG1.connectByCircle();
        graphGeneratorG1.generateG1(6);
        DijOriginMaxBand dijOriginMaxBand1 = new DijOriginMaxBand(5000,23,1238,graphListG1.get(0));
        dijOriginMaxBand1.maxBandWidth();
        Stack<Integer> path = dijOriginMaxBand1.getPath();
        while(path.size()>1){
            int v = path.pop();
            System.out.print(v + "-->");
            int next = path.peek();
            boolean find = false;
            LinkedList<VEPair> vNeighbour = graphListG1.get(0).getNeighbours(v);
            for (int i = 0; i<vNeighbour .size();i++){
                if(vNeighbour.get(i).getNumber() == next){
                    find = true;
                }
            }
            assertTrue(find);
        }
        System.out.print(path.pop());
    }
    @Test
    void testG1100(){
        LinkedList<Graph> graphListG1 = new LinkedList<Graph>();

        for (int i = 0; i < 2; i++) {
            graphListG1.add(new Graph(100));

        }

        GraphGenerator graphGeneratorG1 = new GraphGenerator(20,graphListG1);
        graphGeneratorG1.connectByCircle();
        graphGeneratorG1.generateG1(6);
        DijOriginMaxBand dijOriginMaxBand1 = new DijOriginMaxBand(100,3,40,graphListG1.get(0));
        dijOriginMaxBand1.maxBandWidth();
        Stack<Integer> path = dijOriginMaxBand1.getPath();
        while(path.size()>1){
            int v = path.pop();
            System.out.print(v + "-->");
            int next = path.peek();
            boolean find = false;
            LinkedList<VEPair> vNeighbour = graphListG1.get(0).getNeighbours(v);
            for (int i = 0; i<vNeighbour .size();i++){
                if(vNeighbour.get(i).getNumber() == next){
                    find = true;
                }
            }
            assertTrue(find);
        }
        System.out.print(path.pop());
    }

    @Test
    void testG25000(){
        LinkedList<Graph> graphListG2 = new LinkedList<Graph>();

        for (int i = 0; i < 2; i++) {
            graphListG2.add(new Graph(5000));

        }

        GraphGenerator graphGeneratorG2 = new GraphGenerator(20,graphListG2);
        graphGeneratorG2.connectByCircle();
        graphGeneratorG2.generateG2(1000,10,2500000);
        DijOriginMaxBand dijOriginMaxBand2 = new DijOriginMaxBand(5000,23,1238,graphListG2.get(0));
        dijOriginMaxBand2.maxBandWidth();
        Stack<Integer> path = dijOriginMaxBand2.getPath();
        while(path.size()>1){
            int v = path.pop();
            System.out.print(v + "-->");
            int next = path.peek();
            boolean find = false;
            LinkedList<VEPair> vNeighbour = graphListG2.get(0).getNeighbours(v);
            for (int i = 0; i<vNeighbour .size();i++){
                if(vNeighbour.get(i).getNumber() == next){
                    find = true;
                }
            }
            assertTrue(find);
        }
        System.out.print(path.pop());
    }

    @Test
    void testG1Initialize(){
        LinkedList<Graph> graphListG1 = new LinkedList<Graph>();

        for (int i = 0; i < 5; i++) {
            graphListG1.add(new Graph(10));

        }

        GraphGenerator graphGeneratorG1 = new GraphGenerator(20,graphListG1);
        graphGeneratorG1.connectByCircle();
        DijOriginMaxBand dijOriginMaxBand = new DijOriginMaxBand(10,2,8,graphListG1.get(0));
        dijOriginMaxBand.initialize();
        System.out.println("status" + Arrays.toString(dijOriginMaxBand.getStatus()));
        System.out.println("Bws" + Arrays.toString(dijOriginMaxBand.getBw()));
        System.out.println("Dads" + Arrays.toString(dijOriginMaxBand.getDad()));
        graphListG1.get(0).printG();

    }


}