//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main1 {

    public static void main(String[] args) {
        String FILENAME = "ada-w08-hw/people1.txt";

        PeopleGraph peopleGraph = PeopleGraph.fromFile(FILENAME);
        peopleGraph.printBiggestInfluenceGroup();

    }
}