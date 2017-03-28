package ru.java.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Studenov-DV on 20.03.2017.
 */
public class ContactDataGenerator {

    //-f src/test/resources/contacts.xml -c 2 -d xml

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jcommander = new JCommander(generator);
        try {
            jcommander.parse(args);
        } catch (ParameterException ex){
            jcommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")){
            saveAsCSV(contacts, new File(file));
        } else if (format.equals("xml")){
            saveAsXML(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format" + format);
        }
    }

    private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(ContactData.class);
        String xml = xStream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private void saveAsCSV(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for(ContactData contact : contacts){
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s \n", contact.getName(), contact.getLast_name()
                    , contact.getAddress(), contact.getEmail1(), contact.getMobile_number(), contact.getGroup()
                    , contact.getCompany()));
        }
        writer.close();
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts= new ArrayList<ContactData>();
        for (int i =0; i<count; i++) {
            contacts.add(new ContactData().withName(String.format("name %s", i)).withLast_name(String.format("last_name %s", i))
                    .withAddress(String.format("Street %s, home %s", i, i+1)).withEmail1(String
                            .format("email%s@mail.ru", i)).withMobile_number(String
                            .format("+790345677%s%s", cut(i), cut(i+1))).withGroup("").withCompany(String.format("company %s", i))
                    .withWork_phone("8968999 99 99").withPhone_number("8(987)4564545").withEmail2("email2@,ail.ru")
            .withEmail3("email3@mail.ru"));
        }
        return contacts;
    }
    public int cut(int i) {
        if (i>9){
            return i%10;
        }else return i;
    }
}
