function toggleSaldo() {
    var saldoElement = document.getElementById('saldo');
    var eyeIcon = document.getElementById('eyeIcon');

    if (saldoElement.style.display === 'none') {
        saldoElement.style.display = 'block';
        eyeIcon.setAttribute('name', 'eye-outline'); // Altera o ícone para olho aberto
    } else {
        saldoElement.style.display = 'none';
        eyeIcon.setAttribute('name', 'eye-off-outline'); // Altera o ícone para olho fechado
    }
}