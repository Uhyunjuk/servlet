<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet_study.domain.member.MemberRepository" %>
<%@ page import="hello.servlet_study.domain.member.Member" %>

<%
    // jsp도 servlet으로 동작하기 때문에 request, response 변수 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("save.jsp");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
성공!
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>


