<%--
  Created by IntelliJ IDEA.
  User: AnassBairouk
  Date: 2019-01-26
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en" prefix="og: http://ogp.me/ns#">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0" />
    <meta name="description" content="Our current poll is: is that true ?. Feel free to answer it." />
    <meta property='og:type' content='website' />
    <meta property='og:url' content='${poll_url}' />
    <meta property='og:title' content='is that true ? - Premium Poll Script' />
    <meta property='og:description' content='Our current poll is: is that true ?. Feel free to answer it.' />
    <title> Azerf Poll </title>

    <link href="https://gempixel.com/polls/themes/default/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="https://gempixel.com/polls/themes/default/style.css">
    <link rel="stylesheet" type="text/css" href="https://gempixel.com/polls/themes/default/css/widgets.css">
    <link rel="stylesheet" type="text/css" href="https://gempixel.com/polls/static/js/flat/_all.css">
    <link rel="stylesheet" type="text/css" href="https://gempixel.com/polls/static/js/chosen.min.css">

    <script type="text/javascript" src="https://gempixel.com/polls/static/js/jquery.min.js?v=1.11.0"></script>
    <script type="text/javascript" src="https://gempixel.com/polls/static/js/chosen.min.js?v=0.8.5"></script>
    <script type="text/javascript" src="https://gempixel.com/polls/static/js/icheck.min.js?v=1.0.1"></script>
    <script type="text/javascript" src="https://gempixel.com/polls/static/js/jquery-ui.min.js?v=1.10.3"></script>
    <script type="text/javascript" src="https://gempixel.com/polls/static/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://gempixel.com/polls/static/application.fn.js?v=1.0"></script>

    <script>
        var appurl="http://localhost:8080/Azerf_Poll_war_exploded/";
        var token="703dbf82c57d85152e84d99365a0494a";
        var max_count= 10;
    </script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class='dark'>
<%
    //this one to  prevent the any user from going back to the dashboard.jsp if he didn't login
    if (session.getAttribute("_current_user")==null){
        response.sendRedirect("/login.jsp");
    }
%>

<section>
    <div class="container">
        <div class="centered poll">
            <div class="site_logo">
                <h3><a href="http://localhost:8080/Azerf_Poll_war_exploded/">Azerf Poll </a></h3>
            </div>
            <div id="poll_widget" class=" ">
                <div class='poll_results' data-action='result.display' data-id='R5RWn'>
                    <div id='poll_question'>
                        <h3> ${question._description} </h3>
                    </div>
                    <ul class='results'>

                        <c:forEach var="choice" varStatus="i"  items="${choices}">
                            <li>
                                <div class="holder">${choice._description} </div>
                                <div class="row">
                                    <div class="col-xs-9">
                                        <div class="progress">
                                            <div class="progress-bar" role="progressbar" aria-valuenow="${choice._numberOfVoters*100/total_voters}">
                                                    ${choice._numberOfVoters*100/total_voters}%
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-3">${choice._numberOfVoters} Votes</div>
                                </div>
                            </li>
                        </c:forEach>


                    </ul><h4><span>${total_voters}</span>
                    <div class="branding pull-right">
                    <a href="http://localhost:8080/Azerf_Poll_war_exploded/" target="_blank" style="color:#fff">Azerf Poll </a>
                </div></h4><div class='box-holder slidedown none'>
                    <div class='input-group'>
                        <span class='input-group-addon'>Share</span>
                        <input type='text' class='form-control onclick-select' value='${urlPoll}'>
                    </div>
                    <div class='input-group'>
                        <a href="https://www.facebook.com/sharer.php?u=${urlPoll}" class="btn btn-transparent" target="_blank">Share on Facebook</a>
                        <a href="https://twitter.com/share?url=${urlPoll}" class="btn btn-transparent" target="_blank">Share on Twitter</a>
                    </div>
                </div></div> </div>
            <footer>
                <p>&copy; 2019 <a href="http://localhost:8080/Azerf_Poll_war_exploded/">Azerf Poll </a></p>
            </footer>
        </div>
    </div>
</section> </div>
</div>
</div>
</section>
<script type="text/javascript" src="https://gempixel.com/polls/static/application.js?v=1.0"></script>
</body>
</html>