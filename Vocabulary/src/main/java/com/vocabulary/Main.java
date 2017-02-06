package com.vocabulary;
/**
 * Created by Strus Sviatoslav on 05.02.2017.
 */
import com.vocabulary.json.Doc;
import com.vocabulary.json.Parser;
import java.io.*;
import java.util.ArrayList;

public class Main {

    private static int year = 2016;
    private static int month = 12;

    public static void main(String args[]) throws FileNotFoundException {
        Parser parser = new Parser();
        ArrayList<Doc> list = parser.getData(year, month);

        for (Doc doc : list){
            System.out.println(doc.getLeadParagraph());
            System.out.println();
        }
    }
}