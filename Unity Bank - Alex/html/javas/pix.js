
document.querySelectorAll('.itemPIX').forEach(function(button) {
    button.addEventListener('click', function(event) {
        event.preventDefault();
        const message = button.getAttribute('data-message');
        const usuarioInput = prompt(message);
        if (usuarioInput !== null) {
            alert('Conta encontrada com sucesso: ' + usuarioInput);
        }
    });
});

