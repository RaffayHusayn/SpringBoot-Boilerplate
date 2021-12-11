<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>

<h2>Add a new City</h2>
<form action="addcity" >
    <input name = "cityId">
    <input name = "cityName">
    <input name = "cityCountry">
    <input type="submit" >
</form>


<h2>Find a City</h2>
<form action="getcity">
    <input name = "cityId">
    <input type="submit">
</form>

${deletecity}
<h2>Delete a City</h2>
<form action="deletecity">
    <input name = "cityId">
    <input type="submit">
</form>

${updatecity}
<h2>Update City</h2>
<form action="updatecity" >
    <input name = "cityId">
    <input name = "cityName">
    <input name = "cityCountry">
    <input type="submit" >
</form>
</body>
</html>