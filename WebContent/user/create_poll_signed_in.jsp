<%--
  Created by IntelliJ IDEA.
  User: AnassBairouk
  Date: 2019-01-20
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <meta property='og:title' content='Create your poll for free - Premium Poll Script' />
    <meta property='og:description' content='The best poll script that you will ever find on the internet. It comes packed with tones of awesome features. Give it a try!' />
    <title>Create your poll for free - Azerf Poll </title>

    <link href="../themes/default/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="../themes/default/style.css">
    <link rel="stylesheet" type="text/css" href="../themes/default/css/widgets.css">
    <link rel="stylesheet" type="text/css" href="../static/js/flat/_all.css">
    <link rel="stylesheet" type="text/css" href="../static/js/chosen.min.css">
    <link rel="stylesheet" type="text/css" href="../themes/default/css/bootstrap-datetimepicker.min.css">


    <script type="text/javascript" src="../static/js/jquery.min.js?v=1.11.0"></script>
    <script type="text/javascript" src="../static/js/chosen.min.js?v=0.8.5"></script>
    <script type="text/javascript" src="../static/js/icheck.min.js?v=1.0.1"></script>
    <script type="text/javascript" src="../static/js/jquery-ui.min.js?v=1.10.3"></script>
    <script type="text/javascript" src="../static/bootstrap.min.js"></script>
    <script type="text/javascript" src="../static/application.fn.js?v=1.0"></script>
    <script type="text/javascript" src="../static/js/bootstrap-datetimepicker.min.js"></script>

    <script>
        var appurl="http://localhost:8080/Azerf_Poll_war_exploded/index.jsp";
        var token="703dbf82c57d85152e84d99365a0494a";
        var max_count= 10;
    </script>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans|Ubuntu+Mono|Droid+Sans+Mono|Montez' rel='stylesheet' type='text/css'>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class='dark'>
<%
    //this one to  prevent the any user from going back to the dashboard.jsp if he didn't login
    if (session.getAttribute("_current_user")==null){
        response.sendRedirect("../index.jsp");
    }
%>
<header>
    <div class="navbar" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="glyphicon glyphicon-list"></span>
                </button>
                <div class="site_logo">
                    <a class="navbar-brand" href="http://localhost:8080/Azerf_Poll_war_exploded/index.jsp">Azerf Poll</a>
                </div>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav pull-right">
                    <li><a href="dashboard.jsp">My Account</a></li>
                    <li><a href="settings.user">Settings</a></li>
                    <li><a href="user.logout">Logout</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>
<section>
    <div class="container create">
        <div class="row">
            <div class="col-md-5">
                <div class="box-holder">
                    <form  method="get" action="create.poll">
                        <div id="container_questions" class="tabbed">
                            <div class="form-group">
                                <label for="questions">Your Question</label>
                                <span class="help-block">No HTML allowed. Invalid question will be ignored.</span>
                                <input type="text" class="form-control" id="questions" name="question">
                            </div>
                            <div class="form-group" id="widget_answers">
                                <label>Answers</label>
                                <span class="help-block">Leave fields empty to ignore options. No HTML allowed. Invalid answers will be ignored.</span>
                                <ul id="sortable">
                                    <li id="poll_sort_1">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-move"></i></span>
                                            <input type="text" class="form-control" name="option[]">
                                        </div>
                                    </li>
                                    <li id="poll_sort_2">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-move"></i></span>
                                            <input type="text" class="form-control" name="option[]">
                                        </div>
                                    </li>
                                    <li id="poll_sort_3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-move"></i></span>
                                            <input type="text" class="form-control" name="option[]">
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <button type="button" data-id="customize" class="btn btn-primary tabs pull-right">Customize &rarr;</button>
                            <a href="#" id="add-field" class="btn btn-transparent"><small>Add Field</small></a>
                        </div>
                        <%----------------------------------------------------------------%>
                        <%----------------------------------------------------------------%>
                        <div id="customize" class="tabbed">
                            <%--<ul class="form_opt" data-id="choice" data-callback="update_choice_type">--%>
                                <%--<li class="label">Multiple Choices <small>Allows users to choose more than one option.</small>--%>
                                <%--</li>--%>
                                <%--<li><a href="#" class="last current" data-value="0">No</a></li>--%>
                                <%--<li><a href="#" class="first" data-value="1">Yes</a></li>--%>
                            <%--</ul>--%>
                            <%--<input type="hidden" name="choice" id="choice" value="0">--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="expires">Expires in</label>--%>
                                <%--<input type="date" name="expires" id="expires" />--%>
                                    <div class="row">
                                        <div class='col-sm-6'>
                                            <div class="form-group">
                                                <label >Expires in</label>
                                                <div class='input-group date' id='datetimepicker1'>
                                                    <input type='text' name="expires" class="form-control" />
                                                    <span class="input-group-addon">
                                                        <span class="glyphicon glyphicon-calendar"></span>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <script type="text/javascript">
                                            $(function () {
                                                $('#datetimepicker1').datetimepicker();
                                            });
                                        </script>
                                    </div>
                                <%--<select id="expires" name="expires">
                                    <option value="0">Never</option>
                                    <option value="1h">1 hour</option>
                                    <option value="5h">5 hours</option>
                                    <option value="1d">1 day</option>
                                    <option value="5d">5 days</option>
                                    <option value="1w">1 week</option>
                                    <option value="5w">5 weeks</option>
                                </select>--%>
                            <%--</div>--%>
                            <button type="button" data-id="container_questions" class="btn btn-success tabs">&larr; Questions</button>
                            <button type="button" data-id="theme" class="btn btn-primary tabs pull-right">Forward &rarr;</button>
                        </div>
                        <div id="theme" class="tabbed">
                            <button type="button" data-id="customize" class="btn btn-success tabs">&larr; Back</button>
                            <input type='hidden' name='token' value='23bdb85af881ea6b0098305b14583d9edf42f58b' /> <button type="submit" class="btn btn-primary pull-right">Create</button>
                        </div>
                    </form>
                </div>
            </div>

            <div class="col-md-7">
                <div id="poll_widget">
                    <a href="#embed" id="poll_embed">Share</a>
                    <div id="poll_embed_holder" class="live_form">
                        <div class="input-group">
                            <span class="input-group-addon">Share</span>
                            <input type="text" class="form-control" value="Your permalink will show up here">
                        </div>
                        <div class="input-group">
                            <a href="#" class="btn btn-transparent">Share on Twitter</a>
                            <a href="#" class="btn btn-transparent">Share on Facebook</a>
                        </div>
                    </div>
                    <div id="poll_question">
                        <h3>Question</h3>
                    </div>
                    <ul id="poll_answers"></ul>
                    <div id="poll_button">
                        <button class="btn btn-widget">Vote</button>
                        <button class="btn btn-widget" id="view_results_button">View Results</button>
                        <span class="branding pull-right">
Powered by <a href="http://localhost:8080/Azerf_Poll_war_exploded/index.jsp">Azerf Poll</a>
</span>
                    </div>
                </div>
                <div class='ads ad468'><img src="http://placehold.it/468x60/E8117F/FFFFFF"></div> </div>
        </div>
    </div>
</section> <section>
    <div class="container">
        <footer class="row">
            <p>&copy; 2019 <a href="http://localhost:8080/Azerf_Poll_war_exploded/index.jsp">Azerf Poll </a></p>
        </footer>
    </div>
</section>
<script type="text/javascript" src="../static/application.js?v=1.0"></script>
</body>
</html>