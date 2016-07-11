package document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class EfficientDocumentGrader {
    public static void main(String[] args) {
        try
        {
        	long t1= System.nanoTime();
            System.out.println("Sentences, words, and syllables:");
            BufferedReader br = new BufferedReader(new FileReader("test_cases/mod2TestCases.txt"));
            String line;
            PrintWriter out = new PrintWriter("grader_output/module2.part1.out", "utf-8");
            while ((line = br.readLine()) != null)
            {
                EfficientDocument doc = new EfficientDocument(line);
                String result = doc.getNumSentences() + " " + doc.getNumWords() + " " + doc.getNumSyllables() + " ";
                System.out.print(result);
                out.print(result);
            }
            out.print("\n");
            out.close();
            
            System.out.println("\nFlesch scores:");
            System.out.println(System.nanoTime());
            br.close();
            
            br = new BufferedReader(new FileReader("test_cases/mod2TestCases.txt"));
            out = new PrintWriter("grader_output/module2.part2.out", "utf-8");
            while ((line = br.readLine()) != null)
            {
                EfficientDocument doc = new EfficientDocument(line);
                String result = doc.getFleschScore() + " ";
                System.out.print(result);
                out.print(result);
            }
            out.print("\n");
            out.close();
            System.out.print('\n');
            long t2 = System.nanoTime();
            int mag = (int) Math.pow(10, 9);
            System.out.println((float)(t2-t1)/(float)mag);;
            System.out.println("seconds");
            br.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
