package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "titles")
public class Title {
    @Id
    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "Title")
    private String Title;

    @Column(name = "EditionNumber")
    private Integer EditionNumber;

    @Column(name = "Copyright")
    private String Copyright;

    public Title() {}

    public Title(String ISBN, String Title, Integer EditionNumber, String CopyRight) {
        this.ISBN = ISBN;
        this.Title = Title;
        this.EditionNumber = EditionNumber;
        this.Copyright = CopyRight;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public Integer getEditionNumber() {
        return EditionNumber;
    }

    public String getCopyright() {
        return Copyright;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setEditionNumber(Integer editionNumber) {
        EditionNumber = editionNumber;
    }

    public void setCopyright(String copyright) {
        Copyright = copyright;
    }
}
