<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Send Email</title>
    <link href="<c:url value='/resources/CSS/SendEmail.css'/>" rel="stylesheet">
</head>
<body>
    <form name="frm" action="SendEmails" method="POST" >
        <div class="email-container">
            <h2>Compose Email</h2>

            <!-- To Field -->
            <div class="form-group">
                <label for="to">To:</label>
                <input type="email" id="to" name="to" placeholder="Recipient's email" required>
            </div>

            <!-- Subject Field -->
            <div class="form-group">
                <label for="subject">Subject:</label>
                <input type="text" id="subject" name="subject" placeholder="Email subject" required>
            </div>

            <!-- Message Body Field -->
            <div class="form-group">
                <label for="message">Message:</label>
                <textarea id="message" name="message" placeholder="Write your email here..." required></textarea>
            </div>

           <!--   File Upload Field
            <div class="form-group">
                <label for="file">Attach File:</label>
                <input type="file" id="file" name="file">
            </div> -->

            <!-- Send Button -->
            <button type="submit" class="send-btn">Send</button>
        </div>
        <p>${message}</p>
    </form>
</body>
</html>
