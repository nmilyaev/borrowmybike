<html>
<head>
</head>

<body>
<h1>Registering new user</h1>
<g:hasErrors>
    <div class="error">
        <g:renderErrors bean="${user}" as="list"/>
    </div>
</g:hasErrors>

<g:form action="create" method="POST">
    <table>
        <tr>
            <td><label>User name:</label>
            </td>
            <td>
                <g:textField name="userId" value="${user?.userId}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>Password:</label>
            </td>
            <td>
                <g:passwordField name="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>Confirm Password:</label>
            </td>
            <td>
                <g:passwordField name="confirmPassword"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>Email:</label>
            </td>
            <td>
                <g:textField name="profile.email" value="${user?.profile?.email}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>About me:</label>
            </td>
            <td>
                <g:textField name="profile.about" value="${user?.profile?.about}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>Full Name:</label>
            </td>
            <td>
                <g:textField name="profile.fullName" value="${user?.profile?.fullName}"/>
            </td>
        <tr>
        <tr>
            <td>
                <label>Postcode:</label>
            </td>
            <td>
                <g:textField name="profile.postcode" value="${user?.profile?.postcode}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>Country:</label>
            </td>
            <td>
                <g:textField name="profile.country" value="${user?.profile?.country}"/>
            </td>
        </tr>

        <tr>
            <td>
                <g:submitButton name="create" value="Create" />
            </td>
            <td>
                <button name="Cancel">Cancel</button>
            </td>
        </tr>

    </table>
</g:form>

</body>
</html>

