package id.ac.pcr.springhibernate.service;

import id.ac.pcr.springhibernate.model.Mahasiswa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: isaninside
 * Date: 4/4/13
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class MahasiswaService {
    @PersistenceContext
    protected EntityManager entityManager;
    
    public void save(Mahasiswa mahasiswa){
        if (mahasiswa.getId() != null) {
            Mahasiswa updated = entityManager.find(Mahasiswa.class, mahasiswa.getId());
            updated.setNim(mahasiswa.getNim());
            updated.setNama(mahasiswa.getNama());
            mahasiswa = updated;
        }
        entityManager.persist(mahasiswa);
    }
    
    public  void delete(Long id){
        if (id != null){
            Mahasiswa deleted = entityManager.find(Mahasiswa.class, id);
            entityManager.remove(deleted);
        }
    }
    
    public Mahasiswa findMahasiswa(Long id) {
        return entityManager.find(Mahasiswa.class, id);
    }
    
    public List<Mahasiswa> findMahasiswa() {
        return entityManager.createQuery("SELECT o FROM Mahasiswa o ORDER BY o.id").getResultList();
    }


    @SuppressWarnings("unchecked")
    public List<Mahasiswa> findMahasiswas(int start, int max) {
        return entityManager.createQuery("SELECT o from Mahasiswa o order by o.id").setFirstResult(start).setMaxResults(max).getResultList();
    }

    public List<Mahasiswa> findByNama(String nama) {
        return entityManager.createQuery("SELECT o FROM Mahasiswa o WHERE o.nama LIKE :nama").setParameter("nama", "%" + nama + "%").getResultList();
    }


    public Long countMahasiswas() {
        return (Long) entityManager.createQuery("select count(o) from Mahasiswa o").getSingleResult();
    }

}

