function showList(link) {
    const linkText = link.innerText;
    const listItems = document.querySelectorAll('.locationAreaList');

    listItems.forEach(function(item) {
        if (item.innerText === linkText || item.innerText.includes(linkText)) {
            item.style.display = 'flex';
        } else {
            item.style.display = 'none';
        }
    });
}