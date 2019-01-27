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
<meta property='og:url' content='https://gempixel.com/polls' />
<meta property='og:title' content='My Settings - Premium Poll Script' />
<meta property='og:description' content='The best poll script that you will ever find on the internet. It comes packed with tones of awesome features. Give it a try!' />
<title>My Settings - Premium Poll Script</title>

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
      var appurl="https://gempixel.com/polls";
      var token="703dbf82c57d85152e84d99365a0494a";
            var max_count= 10;      
          </script>
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<form action="_controller_settings" method="post">
<header class="full">
<div class="navbar" role="navigation">
<div class="container-fluid">
<div class="row">
<div class="col-md-2">
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
<span class="glyphicon glyphicon-align-justify"></span>
</button>
<a class="navbar-brand" href="https://gempixel.com/polls">Poll Application</a>
</div>
</div>
<div class="navbar-collapse collapse">
<ul class="nav navbar-nav navbar-right">

<li><a href="https://gempixel.com/polls/create" class="active">Go back to dashboard</a></li>
<li><a href="https://gempixel.com/polls/user/logout">Logout</a></li>
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
<a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="42292a23262b2f6c312324232302252f232b2e6c212d2f">[email&#160;protected]</a>
</div>
</div>
</div>
<form action="https://gempixel.com/polls/user/search" class="search" id="poll_search_form">
<div class="input-group">

</div>
</form>

<h3>Account info <span class="label label-primary pull-right"></span></h3>

</div>
</div>
<div class="col-md-10 content">

<div class='row'>
<div class='col-md-4'>
<form action='https://gempixel.com/polls/user/settings' class='box-holder' method='post'>
<div class='form-group'>
<label for='name'>First name</label>
<input type='text' class='form-control' id='firstname' placeholder='Enter Name' name="firstname" value=''>
</div>
<div class='form-group'>
<label for='name'>Last name</label>
<input type='text' class='form-control' id='lastname' placeholder='Enter Name' name="lastname" value=''>
</div>
<div class='form-group'>
<label for='name'>Birth date</label>
<input type='text' class='form-control' id='birthdate' placeholder='Enter Name' name='birthdate' value=''>
</div>
<div class='form-group'>
<label for='name'>Gender</label>
<input type='text' class='form-control' id='gender' placeholder='Enter Name' name='gender' value=''>
</div>
<div class='form-group'>
<label for='name'>Nationality</label>
<input type='text' class='form-control' id='nationality' placeholder='Enter Name' name='nationality' value=''>
</div>
<div class='form-group'>
<label for='name'>Profile image</label>
<input type='text' class='form-control' id='image' placeholder='Enter Name' name='image' value=''>
</div>
<div class='form-group'>
<label for='email'>Email address</label>
<input type='email' class='form-control' id='email' placeholder='Enter email' name='email' value=''>
</div>
<div class='form-group'>
<label for='pass'>New Password</label>
<input type='password' class='form-control' id='pass' placeholder='password' name='password' value=''>
</div>
</form>

</div>


 <input type="hidden" name="update" value="up" /> <button type="submit" class="btn btn-primary">Update</button>
            

</div>

</div> </div>
</div>
</div>
</section>

<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script type="text/javascript" src="https://gempixel.com/polls/static/application.js?v=1.0"></script>
</form>
</body>
</html>