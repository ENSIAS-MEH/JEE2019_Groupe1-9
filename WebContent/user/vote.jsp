<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en" prefix="og: http://ogp.me/ns#">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0" />
<meta name="description" content="The best poll script that you will ever find on the internet. It comes packed with tones of awesome features. Give it a try!" />
<meta property='og:type' content='website' />
<meta property='og:url' content='dashboard.user' />
<meta property='og:title' content='User Account - Premium Poll Script' />
<meta property='og:description' content='The best poll script that you will ever find on the internet. It comes packed with tones of awesome features. Give it a try!' />
<title>User Account - Azerf Poll</title>

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

    <link href="../themes/default/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="../themes/default/style.css">
    <link rel="stylesheet" type="text/css" href="../themes/default/css/widgets.css">
    <link rel="stylesheet" type="text/css" href="../static/js/flat/_all.css">
    <link rel="stylesheet" type="text/css" href="../static/js/chosen.min.css">

    <script type="text/javascript" src="../static/js/jquery.min.js?v=1.11.0"></script>
    <script type="text/javascript" src="../static/js/chosen.min.js?v=0.8.5"></script>
    <script type="text/javascript" src="../static/js/icheck.min.js?v=1.0.1"></script>
    <script type="text/javascript" src="../static/js/jquery-ui.min.js?v=1.10.3"></script>
    <script type="text/javascript" src="../static/bootstrap.min.js"></script>
    <script type="text/javascript" src="../static/application.fn.js?v=1.0"></script>

<script>
      var appurl="dashboard.user";
      var token="703dbf82c57d85152e84d99365a0494a";
            var max_count= 10;      
          </script>
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%
    //this one to  prevent the any user from going back to the dashboard.jsp if he didn't login
    if (session.getAttribute("_current_user")==null){
        response.sendRedirect("/login.jsp");
    }
%>

<form action="user.search" method="post">
<header class="full">
<div class="navbar" role="navigation">
<div class="container-fluid">
<div class="row">
<div class="col-md-2">
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
<span class="glyphicon glyphicon-align-justify"></span>
</button>
<a class="navbar-brand" href="activepoll.user"> Azerf Poll</a>
</div>
</div>
<div class="navbar-collapse collapse">
<ul class="nav navbar-nav navbar-right">

<li><a href="create_poll_signed_in.jsp" class="active">Create your Poll</a></li>
<li><a href="user.logout">Logout</a></li>
</ul>
</div>
</div>
</div>
</div>
</header>
<section>
<div class="container-fluid">
<div class="row">
<div class="col-md-2 sidebar">
<div class="sidebar-holder">
<div class="box-holder profile">
<div class="row">
<div class="col-md-3 avatar"><img src="https://www.gravatar.com/avatar/062da5078de84305d043fb6a1d21ddd5?s=150" alt="Gravatar"></div>
<div class="col-md-9">
<a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="94fffcf5f0fdf9bae7f5f2f5f5d4f3f9f5fdf8baf7fbf9">[email&#160;protected]</a>
</div>
</div>
</div>
<form action="user.search" class="search" id="poll_search_form">

<div>
    <div class="pull-left">
        <a href="search.user" type="button" class="btn" name="action" value="search"><i class="glyphicon glyphicon-search"></i></a>
    </div>
    <div>
        <div class="input-group">
            <input type="text" class="form-control" name="type" placeholder="Search for poll">
            
        </div>
    </div>
</div>


</form><br><br>
<ul class="nav nav-sidebar">
<li><a href="dashboard.user" class="active"><span class="glyphicon glyphicon-home"></span> Dashboard</a></li>
<li><a href="activepoll.user" name="action" value="activepoll"><span class="glyphicon glyphicon-th-list"></span> Active Polls</a></li>
<li><a href="expiredpoll.user" name="action" value="expiredpoll"><span class="glyphicon glyphicon-time"></span> Expired Polls</a></li>
<li><a href="settings.user"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
</ul>
<div class="stats">
</div>
</div>
</div>
<div class="col-md-10 content">
<div class='ads ad728'><img src="http://placehold.it/728x90/E8117F/FFFFFF"></div>
<div class='btn-group'>
<button type='button' class='btn btn-primary' id='select_all'>Select All</button>
</div><br><br>

 <c:forEach items="${listepoll2}" var="list">
 
<form action='https://gempixel.com/polls/user/delete' id='delete_all_form' method='post'>
<ul class='poll-list'>
<li class='col-sm-4'>
<div class='option-holder'>
<div class='checkbox'> </div>
<h4>${list._description}</h4>
<p><strong></strong></p>
</div>
<div class='btn-group btn-group-xs'>
<a href='http://localhost:8080/Azerf_Poll_war_exploded/${list._pollId}/result.display' class='btn btn-xs btn-success' target='_blank'>View choices</a>

</div>



</li>
</ul>
</form>

</c:forEach>


















 </div>
</div>
</div>
</section>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script type="text/javascript" src="../static/application.js?v=1.0"></script>
</form>
</body>
</html>