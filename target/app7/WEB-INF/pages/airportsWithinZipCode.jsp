<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>Airports</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>


<body class="span12" >
<h4>Airports within zip-code ${zip_code}</h4>

<div>
    <form:form method="GET" action="airportsWithinZipCode">
        <table>

            <tr>

                <td><form:label path="zip_code"><h3>Enter zipCode</h3></form:label><form:input path="zip_code" ></form:input></td> &nbsp;&nbsp;

                <td><form:label path="distance"><h3>Enter Distance</h3></form:label><form:input path="distance" ></form:input></td>
                <td colspan="2">
                    <input type="submit" value="get airports"/>
                </td>
            </tr>

        </table>
    </form:form>




</div>
<div class="span12">

    <table class="table table-bordered">
        <thead>
        <tr>
            <td>Airport Code</td>
            <td>longitude</td>
            <td>latitude</td>
            <td>city</td>
        </tr>
        </thead>

    <c:forEach var="col" items="${airports}">


       <tr>
            <td>
                    ${col.code}
            </td>
            <td>
                    ${col.longitude}
            </td>
            <td>
                    ${col.latitude}
            </td>
           <td>
                   ${col.city}
           </td>

        </tr>


    </c:forEach>

    </table>
</div>
</body>


</html>

