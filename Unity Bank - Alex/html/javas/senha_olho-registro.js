function mostrarSenha(){
    var inputPass = document.getElementById('registrado_registro')
    var btnShowPass = document.getElementById('btn-senha_registro')

    if(inputPass.type === 'password'){
        inputPass.setAttribute('type', 'text')
        btnShowPass.classList.replace('bi-eye-fill','bi-eye-slash-fill')
    }else{
        inputPass.setAttribute('type', 'password')
        btnShowPass.classList.replace('bi-eye-slash-fill','bi-eye-fill')
    }
} 