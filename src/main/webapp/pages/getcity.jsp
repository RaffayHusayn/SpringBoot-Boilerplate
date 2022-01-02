<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Show City</title>
</head>
<body>

<%
    //prints the logged in username at the top
    out.println("user : " + request.getUserPrincipal().getName());
%>

<a href="home">Home </a>
<h2>
    City by ID:
</h2>
${city}
<h2>
    City by Country :
</h2>
${citybycountry}
<h2>
    IDs greater than :
</h2>
${cityidsgreaterthan}
<h2>
    City Names Starting With :
</h2>
${citynamesstartingwith}
<h2>
   All the Cities in the Mentioned Country Ordered by their Names :
</h2>
${countryorderbycity}
<h2>
    All Cities whose Country name have a specific pattern mentioned :
</h2>
${cityNamesWithCountryPattern}
<h2>
    City ID when City Name and Country Name are mentioned :
</h2>
${cityId}
<h2>
   Cities when the Country Name is mentioned :
</h2>
${citieswithcountry}
</body>
</html>
