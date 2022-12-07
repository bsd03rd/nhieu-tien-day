<%-- 
    Document   : testTransaction
    Created on : Oct 9, 2022, 5:14:08 PM
    Author     : NamDepTraiVL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="withdraw" method="POST">
            <input type="text" name="amount">
            <input type="submit" name="submit">
            <img src="https://img.vietqr.io/image/970422-69962345678910-cRULpm7.jpg?accountName=NGO%20HAI%20NAM&addInfo=NAP%20${userid}" alt="alt"/>
            <table>
                <tr>
                    <th>TransactionID</th>
                    <th>TransactionDate</th>
                    <th>Amount</th>
                    <th>TransactionType</th>
                    <th>Status</th>
                </tr>
                <c:forEach items="${paymentList}" var="payment">
                    <tr>
                        <td>${payment.getPaymentID()}</td>
                        <td>${payment.getRechargeDate()}</td>
                        <td>${payment.getAmount()}</td>
                        <td>${payment.getMethod()}</td>
                        <td>${payment.getStatus()}</td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
