package subbusinesstier.entities;

import subbusinesstier.Facade;
import subbusinesstier.Factory;

import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

/**
 * PU:
 * Dodaj_tytu�_nagrania, Wyszukaj_tytu�_nagrania, Operacje_na_nagraniach, Dodawanie_nagrania, Modyfikacja_nagrania, Wyszukaj_nagrania, Usuwanie_nagrania, Publikuj, Wy�lij_komunikat
 */
public class TitleRecord {

    private List<Record> records;
    private String title;
    private String author;
    private String id;
    private Record record;
    private String genre;
    private String cast;

    public TitleRecord(String id, String title, String author, String cast, String genre) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.genre = genre;
        this.cast = cast;
    }

    public TitleRecord(String id, String title) {
        this.title = title;
        this.id = id;
    }

    public TitleRecord(String id, String title, String author) {
        this.title = title;
        this.id = id;
        this.author = author;
    }

    public TitleRecord(String id, String title, String author, String cast) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.cast = cast;
    }




    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Record getRecord(LocalDate date) {
        return this.record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCast() {
        return this.cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public TitleRecord() {
        records = new ArrayList<>();
    }


    public List<Record> getRecords() {
        return records;
    }

    /**
     * @param records
     */
    public void setRecords(List<Record> records) {
        this.records = records;
    }

    /**
     * @param data
     */
    public ArrayList<Object[]> addRecord(String[] data) {
        Factory factory = new Factory();
        Record newRecord;
        newRecord = factory.createRecord(data);
        if (searchRecord(newRecord) == null) {
            records.add(newRecord);
            newRecord.setTitleRecord(this);
            return getRecordsModel();
        }
        return null;
    }

    /**
     * @param record
     */
    public Record searchRecord(Record record) {
        int index;
        if ((index = records.indexOf(record)) != -1) {
            return (Record) records.get(index);
        }
        return null;
    }

    public Record searchRecord(int number) {

        for (Record record : records) {
            if (record.getNumber() == number)
                return record;
        }
        return null;
    }

    public void deleteRecord(int number) {
        Record record = searchRecord(number);
        records.remove(record);
    }

    /**
     * @param date
     */
    public boolean searchFreeRecord(LocalDate dateStart, LocalDate dateEnd) {
        Record record = null;
        for (int i = 0; i < records.size(); i++) {
            record = records.get(i);
            if (record.isFree(dateStart, dateEnd))
                return true;
        }
        return false;
    }

    public Record getFreeRecord(LocalDate dateStart, LocalDate dateEnd) {
        for (Record record : records) {
            record.isFree(dateStart, dateEnd);
            return record;
        }
        return null;
    }

    public String printRecords() {
        String result = "";
        for (Record record : getRecords()) {
            result += record.toString();
        }
        return result;
    }

    public ArrayList<String> getRecordsOfTitleList() {
        ArrayList<String> recordsOfTitleList = new ArrayList<>();
        Iterator<Record> help = getRecords().iterator();
        while (help.hasNext()) {
            recordsOfTitleList.add(help.next().toString());
        }
        return recordsOfTitleList;
    }

    @Override
    public String toString() {
        String help = "\nTitle: " + getTitle();
        help += " Author: " + getAuthor();
        help += " Cast: " + getCast();
        help += " Genre: " + getGenre();
        return help;
    }

    public String[] toString_() {
        String help[] = new String[5];
        help[0] = getId();
        help[1] = getTitle();
        help[2] = getAuthor();
        help[3] = getCast();
        help[4] = getGenre();
        return help;

    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (getId().equals(((TitleRecord) o).getId())) {
            result = true;
        }
        return result;
    }

    public ArrayList<Object[]> getRecordsModel() {
        ArrayList<Object[]> recordsModel = new ArrayList<>();
        for (Record record : records) {
            recordsModel.add(record._toString_());
        }
        return recordsModel;
    }

    public int getRecordNumber(Object object) {
        Record record = (Record) object;
        return record.getNumber();
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
