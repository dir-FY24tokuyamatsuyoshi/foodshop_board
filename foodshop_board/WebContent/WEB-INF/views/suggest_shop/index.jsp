<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url= "../layout/app.jsp">
    <c:param name = "content">
        <h2>お店の一覧</h2>
        <ul>
            <c:forEach var = "suggest_shop" items = "${suggest_shop}">
                <li>
                    <a href = "${pageContent.request.contextPath }/show?id=${suggest_shop.id}">
                        <c:out value = "${suggest_shop.id }"/>
                    </a>
                    :<c:out value = "${suggest.shopname }"></c:out> $gt; <c:out value="${message.star}" />
                </li>
            </c:forEach>
        </ul>
        
        <p><a href = "${pageContext.request.contextPath }/new">新しく見つけたお店の投稿</a>
    </c:param>
</c:import>