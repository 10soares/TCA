document.querySelector('.btn-login').addEventListener('click', function(){
    document.querySelector('.card-login').style.display = 'flex';
    document.querySelector('.card-register').style.display = 'none';
});

document.querySelector('.btn-register').addEventListener('click', function(){
    document.querySelector('.card-login').style.display = 'none';
    document.querySelector('.card-register').style.display = 'flex';
});