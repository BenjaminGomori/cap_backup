const timeControl = document.querySelector('input[type="datetime-local"]');
const timeControlHidden = document.querySelector('.hid');

window.onload = (event) => {
    console.log('page is fully loaded');
    console.log(timeControlHidden.value);
    console.log(timeControlHidden.value.replace(' ', 'T'));
    timeControl.value = timeControlHidden.value.replace(' ', 'T');
};

timeControl.addEventListener('change', (event) => {
    console.log(timeControl);
    console.log(timeControl.value);
    let date = new Date(timeControl.value);
    console.log(date.toISOString().slice(0, 19).replace('T', ' '));
    timeControlHidden.value = date.toISOString().slice(0, 19).replace('T', ' ');
    console.log(timeControlHidden.value);
});