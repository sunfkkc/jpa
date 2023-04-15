package jpa.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.entity.TableSequence;

public class GeneratorTest {
    private EntityManager entityManager;

    @Before
    public void setup(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sample");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void tearDown(){
        entityManager.close();
    }

    @Test
    public void 테이블_키_생성기_테스트(){
        TableSequence user = new TableSequence();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        TableSequence savedUser = entityManager.find(TableSequence.class,user.getId());

        assertThat(savedUser.getId()).isEqualTo(1);
    }
}
