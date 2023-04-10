import java.util.List;

import javax.persistence.*;

import entity.Member;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
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

        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("기찬");
        member.setAge(26);

        //등록
        em.persist(member);

        //수정
        member.setAge(30);

        //한건 조회
        Member findMember = em.find(Member.class, id);
        System.out.println(findMember);

        //목록조회
        List<Member> members = em.createQuery("select * from Member m", Member.class).getResultList();
        System.out.println("member size: "+members.size());

        //삭제
        em.remove(member);
    }
}
