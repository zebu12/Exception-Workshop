package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.exception.DuplicateException;
import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

    public static void main(String[] args) {

        List<String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        List<String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();

        try {
            List<String> lastNames = CSVReader_Writer.getLastNames();
            NameService nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);

            Person test = nameService.getNewRandomPerson();
            System.out.println(test);

            /**
             * Testing
             */
            //nameService.addFemaleFirstName("Bonjour Jari");
            //nameService.addLastName("Barbar Bachar");
            //nameService.addMaleFirstName("Bachar Asari");
            //List<String> femalesNames = CSVReader_Writer.getFemaleFirstNames();

            for (String name : maleFirstNames) {
                //nameService.addMaleFirstName(name);
                System.out.println(name);            }


        } catch (DuplicateException e) {
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


}
