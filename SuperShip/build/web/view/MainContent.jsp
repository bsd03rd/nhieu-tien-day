<%-- 
    Document   : MainContent
    Created on : Jun 12, 2022, 10:29:54 AM
    Author     : BachDuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <table border="1">
            <thead>
                <tr>
                    <th>item_id</th>
                    <th>category_item_id</th>
                    <th>title_item</th>
                    <th>img_item</th>
                    <th>min_price_item</th>
                    <th>max_price_item</th>
                    <th>Edit/Delete</th>
                </tr>
            </thead>
            <tbody>
                <%                    for (Items i : list) {
                        String encodedString = Base64.getEncoder().encodeToString(i.getImg_item());
                        String MyURL = "data:image/png;base64," + encodedString;

                %>
                <tr>
                    <td><%=i.getItem_id()%></td>
                    <td><%=i.getCategory_item_id()%></td>
                    <td><%=i.getTitle_item()%></td>
                    <td> <img style="width: 50px;height: 50px;" class="card-img-top" src="<%=MyURL%>" alt="..." /></td>
                    <td><%=i.getMin_price_item()%></td>
                    <td><%=i.getMax_price_item()%></td>
                    <td><p style="display: inline-block; margin-right: 4px;cursor: pointer;" onclick="DisPlayEdit(<%=i.getItem_id()%>,<%=i.getCategory_item_id()%>,<%=i.getTitle_item()%>,<%=i.getMin_price_item()%>,<%=i.getMax_price_item()%>)">Edit</p>
                        <a href="Manager_items?opp=delete&delete_item_id=<%=i.getItem_id()%>">Delete</a>
                    </td>

                </tr>
                <%}%>
            </tbody>
        </table>

    </body>
</html>
