package hello.hellospring.repository;

import hello.hellospring.domain.Member;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    private MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        Member result;

        member.setName("jayoon");
        this.repository.save(member);
        result = this.repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(result, member);
        assertThat(result).isEqualTo(member);
//        assertThat(null).isEqualTo(member);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("spring1");
        repository.save(member1);

        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();

        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();

        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void findById() {
        Member member1 = new Member();

        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();

        member2.setName("spring1");
        repository.save(member2);

        Member result = repository.findById(member1.getId()).get();

        assertThat(result).isEqualTo(member1);
    }
}
