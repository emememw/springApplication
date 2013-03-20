<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<form method="post" action="${pageContext.request.contextPath}/j_spring_security_check">
        <div id="passwordLoginOption" class="form">
            <div class="row">
                <div class="label left">
                    <label for="j_username">login:</label>
                </div>
                <div class="right">
                    <div class="textWrapper">
                        <input type="text" name="j_username"/>
                    </div>
                </div>
                <div class="cl"></div>
            </div>
            <div class="row">
                <div class="label left">
                    <label for="j_password">password:</label>
                </div>
                <div class="right">
                    <div class="textWrapper">
                        <input type="password" name="j_password"/>
                    </div>
                </div>
                <div class="cl"></div>
            </div>
            <div class="row">
                <div class="right">
                    <label class="forCheckbox" for='_spring_security_remember_me'>
                        Remember me:
                        <input type='checkbox' name='_spring_security_remember_me'/>
                    </label>
                </div>
                <div class="cl"></div>
            </div>
            <div class="buttons">
                <input type="submit" value="Login"/>
            </div>
        </div>
    </form>
    