<%--
  Created by IntelliJ IDEA.
  User: AnassBairouk
  Date: 2019-01-22
  Time: 14:15
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
    <meta property='og:url' content='https://gempixel.com/polls/nTXVu' />
    <meta property='og:title' content='is that true ? - Premium Poll Script' />
    <meta property='og:description' content='Our current poll is: is that true ?. Feel free to answer it.' />
    <title>Azerf Poll </title>


    <link href="../themes/default/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="../themes/default/style.css">
    <link rel="stylesheet" type="text/css" href="../themes/default/css/widgets.css">
    <link rel="stylesheet" type="text/css" href="../static/js/flat/_all.css">
    <link rel="stylesheet" type="text/css" href="../static/js/chosen.min.css">

    <script type="text/javascript" src="../static/js/jquery.min707e.js?v=1.11.0"></script>
    <script type="text/javascript" src="../static/js/chosen.minc118.js?v=0.8.5"></script>
    <script type="text/javascript" src="../static/js/icheck.minf700.js?v=1.0.1"></script>
    <script type="text/javascript" src="../static/js/jquery-ui.min1ff9.js?v=1.10.3"></script>
    <script type="text/javascript" src="../static/bootstrap.min.js"></script>
    <script type="text/javascript" src="../static/application.fnc619.js?v=1.0"></script>


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
<section>
    <div class="container">
        <div class="centered poll">
            <div class="site_logo">
                <h3><a href="http://localhost:8080/Azerf_Poll_war_exploded/">Azerf Poll</a></h3>
            </div>
            <div id="poll_widget" class=" ">
                <form action="../user.vote" method="get" >
                    <a href="#embed" id="poll_embed">Share</a>
                    <div id="poll_embed_holder" class="live_form">
                        <div class="input-group">
                            <span class="input-group-addon">Share</span>
                            <input type="text" class="form-control" value="${urlPoll}">
                        </div>
                        <div class="input-group">
                            <a href="https://www.facebook.com/sharer.php?u=${urlPoll}" class="btn btn-transparent" target="_blank">Share on Facebook</a>
                            <a href="https://twitter.com/share?url=${urlPoll}" class="btn btn-transparent" target="_blank">Share on Twitter</a>
                        </div>
                    </div>
                    <div id="poll_question">
                        <h3>${question._description}</h3><br><br>
                    </div>
                    <ul id="poll_answerss">
                        <c:forEach var="choice" varStatus="i"  items="${choices}">
                            <li id="poll-${i.count}">
                                <label>
                                    <input type="radio" name="answer" value="${choice._choiceId}" >
                                    <span> ${choice._description} </span>
                                </label>
                            </li> <br><br>
                        </c:forEach>
                    </ul>
                    <div id="poll_button">
                        <input type='hidden' name='token' value='d973fad511e5ac35bbb7249e153ae691e2bd976c' /> <input type="hidden" name="poll_id" id="poll_id" value="${question._pollId}">
                        <input type="submit" class="btn btn-widget" value="Vote">
                        <span class="branding pull-right">
                            Powered by <a href="http://localhost:8080/Azerf_Poll_war_exploded/" target="_blank">Azerf Poll</a>
                        </span>
                    </div>
                </form>
            </div>
            <footer>
                <p>&copy; 2019 <a href="http://localhost:8080/Azerf_Poll_war_exploded/">Azerf Poll</a></p>
            </footer>
        </div>
    </div>
</section> </div>
</div>
</div>
</section>
<script type="text/javascript" src="../static/application.js?v=1.0"></script>
</body>
</html>