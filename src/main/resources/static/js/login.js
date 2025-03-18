// Função para exibir o formulário de login
var btnSignIn = document.querySelector("#signin");
var btnSignUp = document.querySelector("#signup");

var body = document.querySelector("body");

btnSignIn.addEventListener("click", function() {
    body.className = "sign-in-js";
});

btnSignUp.addEventListener("click", function() {
    body.className = "sign-up-js";
});

async function onSignUp() {
    const username = document.querySelector("#username").value;
    const password = document.querySelector("#password").value;
    const email = document.querySelector("#email").value;

    const userData = {
        username: username,
        email: email,
        password: password
    };

    if (!username || !password || !email) {
        alert("Preencha todos os campos!");
    }
    else {
        try {
            const response = await fetch("http://localhost:8080/users/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(userData)
            });
        
            if (response.ok) {
                alert("Cadastro realizado com sucesso!");
            }
            else {
                throw new Error("Erro ao fazer cadastro!");
            }
        } catch (error) {
            console.error("Erro:", error);
        }
    }
}

async function onSignIn() {
    const email = document.querySelector("#email2").value;
    const password = document.querySelector("#password2").value;

    const loginData = {
        email: email,
        password: password
    };

    if (!username || !password || !email) {
        alert("Preencha todos os campos!");
    }
    else {
        try {
            const response = await fetch("http://localhost:8080/users/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(loginData)
            });

            if (!response.ok) {
                throw new Error("Usuário ou senha inválidos");
            }

            const result = await response.json();
            alert("Login bem-sucedido!");
            console.log(result);
            window.location.href = "/main/index.html";
            // Armazenar token no localStorage (caso utilize JWT)
            localStorage.setItem("token", result.token);

        } catch (error) {
            console.error("Erro:", error);
            alert("Erro ao fazer login!");
        }
    }
}
