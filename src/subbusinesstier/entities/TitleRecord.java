package subbusinesstier.entities;

import subbusinesstier.Factory;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import static javax.persistence.CascadeType.ALL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * PU:
 * Dodaj_tytu�_nagrania, Wyszukaj_tytu�_nagrania, Operacje_na_nagraniach, Dodawanie_nagrania, Modyfikacja_nagrania, Wyszukaj_nagrania, Usuwanie_nagrania, Publikuj, Wy�lij_komunikat
 */
@Entity
public class TitleRecord implements Serializable {
    
    private static final long serialVersionUID = 1L;
    //private List<Record> records;
    private String title;
    private String author;
    //private String id;
    //private Record record;
    private String genre;
    private String cast;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    @OneToMany(mappedBy = "titleRecord", cascade = ALL)
    private List<Record> records;
    public List<Record> getRecords(){
        return records;
    }           
    public void setRecords(List<Record> records){
        this.records = records;
    }           
    
    public TitleRecord(Long id, String title, String author, String cast, String genre) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.genre = genre;
        this.cast = cast;
    }

    public TitleRecord(Long id, String title) {
        this.title = title;
        this.id = id;
    }

    public TitleRecord(Long id, String title, String author) {
        this.title = title;
        this.id = id;
        this.author = author;
    }

    public TitleRecord(Long id, String title, String author, String cast) {
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

/*
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
*/
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

    public Record searchRecord(Long number) {

        for (Record record : records) {
            if (record.getId().equals(number))
                return record;
        }
        return null;
    }

    public Long deleteRecord(int number) {
        Record record = searchRecord(new Long(number));
        if(record != null){
            Long idDel = record.getId();
            records.remove(record);
            return idDel;
        }
        return null;
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

    public List<String[]> getRecordStrings() {
        ArrayList<String[]> h = new ArrayList<>();
        for (Record record : getRecords()) {
            h.add(new String[]{record.getId().toString(), record.getTitleRecord().getTitle()});
        }
        return h;
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
        help[0] = getId().toString();
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
        return record.getId().intValue();
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
