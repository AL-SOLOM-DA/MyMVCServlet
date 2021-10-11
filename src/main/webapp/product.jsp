<%@ page import="com.solomanin.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <b>PRODUCT PAGE</b>
        <br/>id:
        <%
            response.getWriter().write(((Product)request.getAttribute("product")).getId());
        %>
        <br/>name: ${product.name}
        <a href="./productAddToBucket.do?id=${product.id}">Add this product to bucket</a>
        <hr/>
        <h2>Product in bucket</h2>
        <ul>
            <c:forEach var="productInBucket" items="${productsInBucket}">
                <li>
                    <a href="./product.do?id=${productInBucket.key.id}">${productInBucket.key.name}</a>: =
                    ${productInBucket.value}
                </li>
            </c:forEach>
        </ul>

    </body>
</html>