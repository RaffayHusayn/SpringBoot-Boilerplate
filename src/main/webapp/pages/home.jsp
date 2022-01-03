<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<%
    //prints the logged in username at the top
    if(request.getUserPrincipal() == null){
        out.println("user: not Logged in");
    }else {
        out.println("user : " + request.getUserPrincipal().getName());
    }
%>
<a href="/logout">logout</a>
<h2>Add a new City</h2>
<form action="addcity" >
    <input name = "cityId" placeholder="Id">
    <input name = "cityName" placeholder="Name">
    <input name = "cityCountry" placeholder="Country">
    <input type="submit" value="Add" >
</form>


<h2>Find a City</h2>
<form action="getcity" >
    <input name = "cityId" placeholder="Id">
    <input type="submit" value="Search">
</form>

${deletecity} <!--attribute name in ModelAndView object-->
<h2>Delete a City</h2>
<form action="deletecity" >
    <input name = "cityId" placeholder="Id">
    <input type="submit" value="Delete">
</form>

${updatecity} <!--attribute name in ModelAndView object-->
<h2>Update City</h2>
<form action="updatecity" >
    <input name = "cityId" placeholder="Id">
    <input name = "cityName" placeholder="Name">
    <input name = "cityCountry" placeholder="Country">
    <input type="submit" value="Update" >
</form>

<form action = "findcitybycountry">
    <h2>Find City by Country</h2>
    <input name="cityCountry" placeholder="Country">
    <input type="submit" value="Search">
</form>


<form action = "findcitybygreaterid">
    <h2>Find City IDs greater than</h2>
    <input name="cityId" placeholder="Id">
    <input type="submit" value="Search">
</form>


<form action = "findcitybynamestartingwith">
    <h2>Find City by Name starting with</h2>
    <input name="prefix" placeholder="Prefix">
    <input type="submit" value="Search">
</form>


<form action = "findbycountrynameorderedbycityname">
    <h2>Find City by Name Ordered by Country Name</h2>
    <input name="cityCountry" placeholder="Country">
    <input type="submit" value="Search">
</form>

<form action = "findcitynamewithcountrypattern">
    <h2>Find City Name with Specific Country Name Pattern</h2>
    <input name="pattern" placeholder="Pattern">
    <input type="submit" value="Search">
</form>


<form action = "findcityidwithcityandcountry">
    <h2>Find City ID when City and Country Name are given</h2>
    <input name="cityName" placeholder="City">
    <input name="cityCountry" placeholder="Country">
    <input type="submit" value="Search">
</form>

<form action="findcitieswithcountry">
    <h2>Find Cities Info with Country Name</h2>
    <input  name="cityCountry" placeholder="Country" >
    <input type="submit" value="Search">
</form>

</body>
</html>