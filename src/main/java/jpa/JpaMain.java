package jpa;


import javax.persistence.*;

import jpa.entity.Member;
import jpa.entity.SequenceBoard;

public class JpaMain {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

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
        updateMember(em);
        setSequenceId(em);
    }

    private static void updateMember(EntityManager em){
        Member member = new Member();
        member.setUsername("기찬");
        member.setAge(26);

        //등록
        em.persist(member);
    }

    private static void setSequenceId(EntityManager em){
        SequenceBoard board = new SequenceBoard();
        em.persist(board);
        System.out.println(board); //id=1 출력
    }


}
