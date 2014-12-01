package com.ordermanager.domain;

import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "ordertable")
public class Order {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "DATE")
    private String date;

    @Column(name = "THEME")
    private String theme;
    
    @Column(name = "FILE")
    @Lob
    private Blob file;
    
    @Column(name = "FILENAME")
    private String filename;
    
    @Column(name = "TYPE")
    private String type;
    
    @Column(name = "NOTES")
    private String notes;
     
    public void setId(Integer newId) {
         id = newId;
    }

    public int getId() {
         return id;
    }
    
    public void setNumber (String newNumber) {
    	number = newNumber;
    }

    public String getNumber() {
        return number;
    }
    
    public void setDate(String newDate) {
        date = newDate;
    }

    public String getDate() {
        return date;
    }
    
    public void setTheme(String newTheme) {
        theme = newTheme;
    }

    public String getTheme() {
        return theme;
    }
    
    public void setFile(Blob blob) {
        file = blob;
    }

    public Blob getFile() {
        return file;
    }
    
    public void setFilename(String originalFilename) {
		filename=originalFilename;
	}
    
	public String getFilename() {
		return filename;
	}
    
    public void setType(String newType) {
        type = newType;
    }

    public String getType() {
        return type;
    }
    
    public void setNotes(String newNotes) {
        notes = newNotes;
    }

    public String getNotes() {
        return notes;
    }
}
