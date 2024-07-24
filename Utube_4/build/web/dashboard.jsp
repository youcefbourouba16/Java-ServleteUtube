<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }
        h1, h2 {
            text-align: center;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 10px;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <% User user1 = (User) request.getAttribute("user"); %>
    <h1>Welcome</h1>
    <h2>Edit Profile <%=user1.getUserName() %></h2>
    <form action="UpdateUser" method="post">
        <label for="profile-email">Email:</label>
        <input type="email" id="profile-email" name="email" value="<%=user1.getEmail() %>" required >
        
        <label for="profile-username">Username:</label>
        <input type="text" id="profile-username" name="username" value="<%=user1.getUserName() %>" required>
        
        <label for="profile-password">New Password :</label>
        <input type="password" id="profile-password" name="password" required="true">
        
        
         <label ><%= (String) request.getAttribute("updateStatus") %></label>
        <button type="submit">Save Changes</button>
        <a style="padding-left: 25%" href="index.html">Go back HOME !</a>
    </form>
</body>
</html>
