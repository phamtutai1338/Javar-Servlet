<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>

        a {
            text-decoration: none;
            font-size:20px;
            font-weight: bold;
            border: solid;
            background-color: black;
            font-style: initial;
            font-family: sans-serif;
            color: white;
            display: inline-block;
            border-radius: 10px;
            text-align: center;
            padding: 10px;

        }
        @keyframes nhay {
            0% {
                opacity: 1;
            }
            50% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        /* Áp dụng animation vào chữ */
        .nhaychuchu {
            animation: nhay 2s infinite;
        }
    </style>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

<a  href="students"  class="nhaychuchu" title="Danh sách sinh viên">Nhấp vào đây !</a>
</body>
</html>