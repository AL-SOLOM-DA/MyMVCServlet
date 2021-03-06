<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.solomanin.entity.Product" %>
<%@ page import="com.solomanin.controller.ProductAddToBucketController" %>
<%@ page import="java.util.Map" %>
<%@ page import="static com.solomanin.controller.SessionAttributes.PRODUCTS_IN_BUCKET" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <b>PRODUCT PAGE</b>
        <br/>id:${product.id}
        <br/>id:<%=((Product)request.getAttribute("product")).getId()%>
        <br/>id:
        <%
            response.getWriter().write(((Product)request.getAttribute("product")).getId());
        %>
        <br/>name: ${product.name}
        <br/>
        <a href="./productAddToBucket.do?id=${product.id}">Add this product to bucket</a>
        <hr/>
        <h2>Product in bucket</h2>
        <ul>
            <c:forEach var="productInBucket" items="${produсtsInBucket}">
                <li>
                    <a href="./product.do?id=${productInBucket.key.id}">${productInBucket.key.name}</a>: =
                    ${productInBucket.value}
                </li>
            </c:forEach>

        </ul>

    </body>
</html>