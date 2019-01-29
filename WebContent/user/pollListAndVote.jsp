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

<form action="_controller_list_vote" method="post">
<header class="full">
<div class="navbar" role="navigation">
<div class="container-fluid">
<div class="row">
<div class="col-md-2">
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
<span class="glyphicon glyphicon-align-justify"></span>
</button>
<a class="navbar-brand" href="dashboard.user">Azerf poll</a>
</div>
</div>
<div class="navbar-collapse collapse">
<ul class="nav navbar-nav navbar-right">


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
<form action="search.user" class="search" id="poll_search_form">
<div>
<div class="input-group pull-left">

<input type="text" class="form-control" id="poll_search_q" placeholder="Search of a poll by type" name="type">

</div>
<button name="actionn" value="search" class="btn btn-info ">search</button>
</div>
</form>
<ul class="nav nav-sidebar">

</ul>
</br>
</br>


 <div class="container btn-block">
       
           
                <c:forEach items="${listepoll}" var="poll">
               <c:set var="a" value="-" />
                 
                
                 <input type="submit" class="list-group-item list-group-item-action list-group-item-warning btn-block " name="actionn" value="${poll._pollId}${a}${poll._description}" onsubmit="return false">
               
                <div style="font-size: 20px">
                 
                 </div>
               
               </br>
               </br>
               </br>
                </c:forEach>
            
       
    </div>


<button name="actionn" value="mypolls" class="btn btn-info btn-block ">my polls</button>
</br>
</br>
<button name="actionn" value="settings" class="btn btn-info  btn-block">settings</button>

<div class="stats">
<p><span>0</span> Polls</p>
<p><span>0</span> Votes</p>
</div>
</div>
</div>
<div class="col-md-10 content">
<div>


</div>

<h4>choose the type of vote</h4>
<select class="form-control" name="typee">
  <option>visible</option>
  <option>anonymous</option>
</select>
</br>
</br>
</br>
<h4>click on poll to delete it or click on choice to vote</h4>

<div class='btn-group'>
<div class="container">
       
           </br>
                <c:forEach items="${listepoll1}" var="poll">
                <c:set var="a" value="-" />
                <c:set var="b" value="*" />
                <input type="submit" class="list-group-item list-group-item-action list-group-item-warning btn-block " name="action2" value="${poll._pollId}${a}${poll._description}">
                </c:forEach>
            
       
    </div>



</div>









<div class='btn-group'>
<div class="container">
       
           
                <c:forEach items="${listechoice}" var="choice">
                <c:set var="a" value="-" />
                <input type="submit" class="list-group-item list-group-item-action list-group-item-warning btn-block " name="action" value="${a}${choice._description}" onclick="return confirm('Are you sure you want to voite for this choice ')">
                  
                  
                        
                </c:forEach>
            
       
    </div>



</div>
<br><br>
<form action='delete' id='delete_all_form' method='post'>
<ul class='poll-list'></ul><input type='hidden' name='token' value='b334bbe96c62af26780af74cc1e01579a18c6da6' /></form> </div>
</div>
</div>
</section>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script type="text/javascript" src="https://gempixel.com/polls/static/application.js?v=1.0"></script>
</form>
</body>
</html>