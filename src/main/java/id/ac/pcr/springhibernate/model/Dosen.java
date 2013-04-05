package id.ac.pcr.springhibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "dosen")
public class Dosen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dosen_id")
    private Long id;
    @Column(name = "niy",unique = true)
    private String niy;
    @Column(name = "nama")
    private String nama;

    @Temporal(TemporalType.DATE)
    private Date createdAt;


    @PrePersist
    public void updateCreatedAt() {
        this.setCreatedAt(new Date());
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNiy() {
        return niy;
    }

    public void setNiy(String niy) {
        this.niy = niy;
    }
}
