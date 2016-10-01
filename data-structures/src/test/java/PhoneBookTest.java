
import org.junit.Test;

public class PhoneBookTest {

    @Test
    public void testProcessQuery() throws Exception {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.processQuery(new PhoneBook.Query("find", 3839442));
        phoneBook.processQuery(new PhoneBook.Query("add", "me", 123456));
        phoneBook.processQuery(new PhoneBook.Query("add", "granny", 0));
        phoneBook.processQuery(new PhoneBook.Query("find", 0));
        phoneBook.processQuery(new PhoneBook.Query("find", 123456));
        phoneBook.processQuery(new PhoneBook.Query("del", 0));
        phoneBook.processQuery(new PhoneBook.Query("del", 0));
        phoneBook.processQuery(new PhoneBook.Query("find", 0));

        //
        // find 3839442
        // add 123456 me
        // add 0 granny
        // find 0
        // find 123456
        // del 0
        // del 0
        // find 0
    }

}
