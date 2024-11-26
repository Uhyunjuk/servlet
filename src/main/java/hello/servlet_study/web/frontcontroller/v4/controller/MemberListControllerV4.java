package hello.servlet_study.web.frontcontroller.v4.controller;

import hello.servlet_study.domain.member.Member;
import hello.servlet_study.domain.member.MemberRepository;
import hello.servlet_study.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findByAll();

        model.put("members", members);
        return "members";
    }
}
