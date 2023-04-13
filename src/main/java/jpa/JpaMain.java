package jpa;

import java.util.List;

import javax.persistence.*;

import jpa.entity.Member;

public class JpaMain {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    private static EntityManager em = emf.createEntityManager();
    private static EntityTransaction tx = em.getTransaction();
    public static void main(String[] args) {


        try{
            tx.begin();
            logic(em);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(EntityManager em){

        Member member = new Member();
        member.setUsername("기찬");
        member.setAge(26);

        //등록
        em.persist(member);

    }

}
