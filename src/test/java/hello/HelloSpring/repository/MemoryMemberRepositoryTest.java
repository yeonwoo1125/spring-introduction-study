package hello.HelloSpring.repository;

import hello.HelloSpring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class MemoryMemberRepositoryTest {
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void atfterEach(){
        memberRepository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        memberRepository.save(member);

        Member res = memberRepository.findById(member.getId()).get();
        //Assertions.assertEquals(member, res);
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(res);

    }

    @Test
    public void findByName(){
        Member member = new Member();
        member.setName("spring1");
        memberRepository.save(member);

        Member member1 = new Member();
        member1.setName("spring2");
        memberRepository.save(member1);

        Member result = memberRepository.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(member);
    }

    @Test
    public void findAll(){
        Member member = new Member();
        member.setName("spring");
        memberRepository.save(member);

        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        List<Member> result = memberRepository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
