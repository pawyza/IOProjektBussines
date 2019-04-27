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
        for(Record record : records){
            record.isFree(date);
            return record;
        }
        return null;
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

    public ArrayList<String> getRecordsModel() {

        ArrayList<String> title_records = new ArrayList<>();
        for (Record next : records) {
            title_records.add(next.toString());
        }
        return title_records;


    }

    /**
     * @param data
     */
    public ArrayList<String> addRecord(String[] data) {
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

        for(Record record : records){
        if (record.getNumber() == number)
            return record;
        }
        return null;
    }

    /**
     * @param date
     */
    public boolean searchFreeRecord(LocalDate date) {
        Record record = null;
        for (int i = 0; i < records.size(); i++) {
            record = records.get(i);
            if (record.isFree(date))
                return true;
        }
        return false;
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
        String help[] = new String[4];
        help[0] = getTitle();
        help[1] = getAuthor();
        help[2] = getCast();
        help[3] = getGenre();
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

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}