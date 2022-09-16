import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CadastroAluno{
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AlunoPU");
        EntityManager em = factory.createEntityManager();

        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("Pedro Neto");
        aluno.setDataNascimento(parseData("30/09/1980"));
        aluno.setIdade(40);
        aluno.setAltura(1.70);
        aluno.setPeso(70.25);
        aluno.setAnoLetivo(2022);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(aluno);
        tx.commit();
        em.close();
        factory.close();
    }
    
    private static Calendar parseData(String data) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (Exception e) {
             throw new IllegalArgumentException(e);
        }
    }
}
