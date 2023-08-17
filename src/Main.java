import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SentenceGenerator sentenceGenerator = new SentenceGenerator();
        sentenceGenerator.addProduction(new Production(100.0, "<S>", "My homework is <r1> late because\n<reason>."));
        sentenceGenerator.addProduction(new Production(30.0, "<reason>", "it is <r1> always late"));
        sentenceGenerator.addProduction(new Production(30.0, "<reason>", "my <r1> <hungry thing> ate it"));
        sentenceGenerator.addProduction(new Production(20.0, "<hungry thing>", "younger <sibling>"));
        sentenceGenerator.addProduction(new Production(20.0, "<hungry thing>", "older <sibling>"));
        sentenceGenerator.addProduction(new Production(50.0, "<sibling>", "brother"));
        sentenceGenerator.addProduction(new Production(50.0, "<sibling>", "sister"));
        sentenceGenerator.addProduction(new Production(30.0, "<hungry thing>", "dog"));
        sentenceGenerator.addProduction(new Production(30.0, "<hungry thing>", "printer"));
        sentenceGenerator.addProduction(new Production(10.0, "<reason>", "<reason>\nand besides <r1> <reason>"));
        sentenceGenerator.addProduction(new Production(20.0, "<r1>", "like"));
        sentenceGenerator.addProduction(new Production(80.0, "<r1>", ""));
        sentenceGenerator.addProduction(new Production(30.0, "<reason>", "I forgot my flash drive"));
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        do {
            printMenu();
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    sentenceGenerator.printProductions();
                    break;
                case 2:
                    System.out.println(sentenceGenerator.getGenerateSentence());
                    break;
                case 3:
                    System.out.println("end");
                    break;

            }
        } while (input != 3);

    }

    private static void printMenu() {
        System.out.print(
                "1./ Show current set of productions.\n" +
                        "2./ Generate sentence created using current set of productions\n" +
                        "3./ end\n"
        );
    }
}
