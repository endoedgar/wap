<!doctype html>
<html>
    <head>
        <title>Introduction to JSP demo - postback page </title>
    </head>
    <body>
        <p>This is the postback message</p>
        
        <%! int count = 0; %>
        The count is now:  <%= ++count %>
        
        <%--This is a jsp scriptlet that increments the count --%>
        <!--This is an html comment inserted by the increment comment -->
        <% count = count * 10; %>
        The count is now:  <%= count %>
    </body>
</html>