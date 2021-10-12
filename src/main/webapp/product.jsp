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
        <br/><a href="allProduct.jsp">ALL PRODUCT</a>
        <hr/>
        <h2>Product in bucket</h2>
        <ul>
            <c:forEach var="productInBucket" items="${productsInBucket}">
                <li>
                    <a href="./product.do?id=${productInBucket.key.id}">${productInBucket.key.name}:${productInBucket.value}</a>
                </li>
            </c:forEach>

        </ul>

    </body>
</html>